package org.example.page_object;

import lombok.Getter;
import org.example.utils.TypesOfLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.time.Duration;

@Getter
public class SignUpPage extends BasePage {

    private static final By countryDropdown = By.id("country");
    private static final By countryField = By.id("register_country_form_input");
    private static final By stateDropdown = By.id("____state_linked_select");
    private static final By stateField = By.id("register_state_form_input");
    private static final By firstNameField = By.id("first_name");
    private static final By lastNameField = By.id("last_name");
    private static final By emailField = By.id("email");
    private static final By phonePrefixDropdown = By.id("__pin_mobile_number_international_dialing_code");
    private static final By mobilePhoneField = By.id("__pin_mobile_number_mobile_phone");
    private static final By termsOfUseAndPrivacyPolicyCheckbox
            = By.id("register_terms_of_use_agree_form_input");
    private static final By newsAndOffersCheckbox = By.id("register_newsletter_and_privacy_policy_agree_form_input");
    private static final By captchaQuestion = By.id("cal_captcha_f10_question");
    private static final By captchaResultBox = By.id("__calc_captcha_text");
    private static final By errorMessageForTryingToRegisterWithAnAlreadyUsedEmail = By.id("register_email_error");
    private static final By errorMessageForTryingToRegisterWithAnAlreadyUsedPhoneNumber = By.id("register___pin_mobile_number_error");
    private static final By errorMessageForNotCheckingTheTermsOfUseAndPrivacyPolicyCheckbox = By.id("register_terms_of_use_agree_error");
    private static final By openMyFreeAccountButton = By.id("button_subscribe");
    private static final By errorForNotSelectingAnAccountTypeAtSignUp
            = By.xpath("(//div[text()='Please Select Account Type'])[1]");
    private static final By acceptCookies = By.id("cookies-read-more-link");
    Actions action = new Actions(driver);

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void openSignUpPage() {
        driver.get("https://transfermate.io/en/register.asp?");
        driver.manage().window().maximize();
        //  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        if (driver.findElement(acceptCookies).isDisplayed()) driver.findElement(acceptCookies).click();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    private WebElement getAccountTypeInputButton(String accountTypeButtonName) {
        return driver.findElement(By.id("register_account_type_" + accountTypeButtonName + "_form_input"));
    }

    public void accountTypeIsSelected(String accountType) {
        getAccountTypeInputButton(accountType).click();
    }

    public void fillDataInField(String fieldName, String sentKeys) {
        String path;

        if (fieldName.equalsIgnoreCase("phone_prefix")) {
            path = "__pin_mobile_number_international_dialing_code";
        } else if (fieldName.equalsIgnoreCase("mobile_phone")) {
            path = "__pin_mobile_number_mobile_phone";
        } else if (fieldName.equalsIgnoreCase("state")) {
            path = "____state_linked_select";
        } else path = fieldName;

        WebElement field = getElementBy(TypesOfLocators.ID, path, 2);
        field.sendKeys(sentKeys);
        // field.sendKeys(Keys.TAB);
    }

    public void checkTheTermsOfUseAndPrivacyPolicyCheckbox(boolean ok) {
        if (ok) {
            new WebDriverWait(driver, Duration.ofMillis(15000))
                    .until(ExpectedConditions.elementToBeClickable(termsOfUseAndPrivacyPolicyCheckbox))
                    .click();
        }
    }

    public void checkTheNewsAndOffersCheckbox(boolean ok) {
        if(ok) {
            new WebDriverWait(driver, Duration.ofMillis(15000))
                    .until(ExpectedConditions.elementToBeClickable(newsAndOffersCheckbox))
                    .click();
        }
    }

    private String getCaptchaQuestionText() {
        return driver.findElement(captchaQuestion).getText();
    }

    private String solveCaptchaQuestion() throws ScriptException {
        String result = getCaptchaQuestionText().replace("=", "").trim();
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        return scriptEngine.eval(result).toString();
    }

    public String getResultOfSolvedCaptcha() {
        try {
            return solveCaptchaQuestion();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void fillInCaptchaResult(String text) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
        driver.findElement(captchaResultBox).sendKeys(text);
        driver.findElement(captchaResultBox).submit();
    }

    public void fillSolvedCaptcha() {
        fillInCaptchaResult(getResultOfSolvedCaptcha());
    }

    public EmailAndMobileNumberVerificationPage clickOnOpenMyFreeAccountButton() {
        driver.findElement(openMyFreeAccountButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        return new EmailAndMobileNumberVerificationPage(driver);
    }

    public String getErrorMessageForTryingToRegisterWithAnAlreadyUsedEmail() {
        return new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageForTryingToRegisterWithAnAlreadyUsedEmail))
                .getText();
    }

    public String getErrorMessageForTryingToRegisterWithAnAlreadyUsedPhoneNumber(){
        return new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageForTryingToRegisterWithAnAlreadyUsedPhoneNumber))
                .getText();
    }

    public String getErrorMessageForNotCheckingTheTermsOfUseAndPrivacyPolicyCheckbox() {
        return new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageForNotCheckingTheTermsOfUseAndPrivacyPolicyCheckbox))
                .getText();
    }
}
