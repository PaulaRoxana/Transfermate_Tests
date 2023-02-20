package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import org.example.page_object.EmailAndMobileNumberVerificationPage;
import org.example.page_object.SignUpPage;
import org.example.utils.ServiceUtils;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

@Log
public class SignUpPageSteps {

    SignUpPage signUpPage = new SignUpPage(BaseSteps.driver);
    EmailAndMobileNumberVerificationPage emailAndMobileNumberVerificationPage =
            new EmailAndMobileNumberVerificationPage(BaseSteps.driver);

    @Given("The Sign Up page is opened")
    public void theSignUpPageIsOpened() {
        signUpPage.openSignUpPage();
        log.info("The page is opened");
    }

    @When("user selects an account type {string}")
    public void userSelectsAnAccountType(String accountType) {
        signUpPage.accountTypeIsSelected(accountType);
    }

    @When("user fills the following fields on the form with given values")
    public void userFillsTheFollowingFieldsOnTheFormWithGivenValues(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String field = "";
        String text = "";
        ServiceUtils serviceUtils = new ServiceUtils();
        String firstName = serviceUtils.generateFirstName();
        String lastName = serviceUtils.generateLastName();
        String email = serviceUtils.generateEmail(firstName, lastName);
        String phoneNumber = serviceUtils.generatePhoneNumber();
        for (Map<String, String> columns : rows) {
            field = columns.get("field name");
            text = switch (field) {
                case "first_name" ->
                        (columns.get("value").contains("Random") && columns.get("value").contains("generate")) ?
                                firstName : columns.get("value");
                case "last_name" ->
                        (columns.get("value").contains("Random") && columns.get("value").contains("generate")) ?
                                lastName : columns.get("value");
                case "email" -> (columns.get("value").contains("Random") && columns.get("value").contains("generate")) ?
                        email : columns.get("value");
                case "mobile_phone" ->
                        (columns.get("value").contains("Random") && columns.get("value").contains("generate")) ?
                                phoneNumber : columns.get("value");
                default -> columns.get("value");
            };
            signUpPage.fillDataInField(field, text);
        }
        log.info("All fields on the form have been filled with the given values");
    }

    @And("user checks the Terms of Use and Privacy Policy checkbox")
    public void userChecksTheTermsOfUseAndPrivacyPolicyCheckbox() {
        signUpPage.checkTheTermsOfUseAndPrivacyPolicyCheckbox(true);
    }

    @And("user checks the News and Offers checkbox")
    public void userChecksTheNewsAndOffersCheckbox() {
        signUpPage.checkTheNewsAndOffersCheckbox(true);
    }

    @And("user enters the correct captcha result")
    public void userEntersTheCorrectCaptchaResult() {
        signUpPage.fillSolvedCaptcha();
    }

    @And("user clicks on Open my free account button")
    public void userClicksOnOpenMyFreeAccountButton() {
        signUpPage.clickOnOpenMyFreeAccountButton();
    }

    @Then("user remains on Sign Up page")
    public void userRemainsOnSignUpPage() {
        String signUpPageTitle = signUpPage.getCurrentPageTitle();
        Assert.assertTrue(signUpPageTitle.contains("Sign up"), "The page title is not correct");
        log.info("The page title is correct");
    }

    @Then("error message {string} is displayed above Email field")
    public void errorMessageIsDisplayedAboveEmailField(String expectedErrorMessage) {
        String actualErrorMessage = signUpPage.getErrorMessageForTryingToRegisterWithAnAlreadyUsedEmail();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "The error message is not correct");
        log.info("The error message is correct");
    }

    @Then("error message {string} is displayed above Mobile Phone field")
    public void errorMessageIsDisplayedAboveMobilePhoneField(String expectedErrorMessage) {
        String actualErrorMessage = signUpPage.getErrorMessageForTryingToRegisterWithAnAlreadyUsedPhoneNumber();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "The error message is not correct");
        log.info("The error message is correct");
    }

    @Then("error message is displayed above Terms of Use and Privacy Policy checkbox")
    public void errorMessageIsDisplayedAboveTermsOfUseAndPrivacyPolicyCheckbox() {
        String actualErrorMessageForNotCheckingTheTermsOfUseAndPrivacyPolicyCheckbox =
                "Click OK to return and check the box that you have read and agree with our Terms of Use";
        String expectedErrorMessageForNotCheckingTheTermsOfUseAndPrivacyPolicyCheckbox =
                signUpPage.getErrorMessageForNotCheckingTheTermsOfUseAndPrivacyPolicyCheckbox();
        Assert.assertEquals(expectedErrorMessageForNotCheckingTheTermsOfUseAndPrivacyPolicyCheckbox,
                actualErrorMessageForNotCheckingTheTermsOfUseAndPrivacyPolicyCheckbox, "The error message is not correct");
        log.info("The error message is correct");

    }

}
