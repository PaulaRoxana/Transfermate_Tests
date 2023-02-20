package org.example.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailAndMobileNumberVerificationPage extends BasePage {

    private static final By checkYourMailText = By.xpath("//h2[text()='Check your mail']");

    public EmailAndMobileNumberVerificationPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String CheckYouMailTextOnThePage() {
        return new WebDriverWait(driver, Duration.ofMillis(7000))
                .until(ExpectedConditions.presenceOfElementLocated(checkYourMailText)).getText();
    }
}
