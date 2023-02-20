package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import lombok.extern.java.Log;
import org.example.page_object.EmailAndMobileNumberVerificationPage;
import org.testng.Assert;

@Log
public class EmailAndMobileVerificationPageSteps {

    EmailAndMobileNumberVerificationPage emailAndMobileNumberVerificationPage
            = new EmailAndMobileNumberVerificationPage(BaseSteps.driver);

    @Then("user is navigated to Email And Mobile Number Verification Page")
    public void userIsNavigatedToEmailAndMobileNumberVerificationPage() {
        String checkYourMailText = emailAndMobileNumberVerificationPage.CheckYouMailTextOnThePage();
        Assert.assertEquals(checkYourMailText, "Check your mail", "The text is not correct");

        String emailAndMobileNumberVerificationPageTitle = emailAndMobileNumberVerificationPage.getCurrentPageTitle();
        Assert.assertTrue(emailAndMobileNumberVerificationPageTitle
                .equalsIgnoreCase("Email and Mobile Number Verification"), "The page title is not correct");
        log.info("The page title " + emailAndMobileNumberVerificationPageTitle + " is correct");

    }
}
