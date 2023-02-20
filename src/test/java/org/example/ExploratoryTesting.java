package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;
import org.example.utils.ServiceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Log
public class ExploratoryTesting {
    WebDriver driver;
    private static final By individualAccountLabel = By.id("register_account_type_individual");
    private static final By countryDropdown = By.id("country");
    private static final By countryField = By.id("register_country_form_input");
    private static final By countryFieldLabel = By.id("register_country");
    private static final By acceptCookies = By.id("cookies-read-more-link");


    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://transfermate.io/en/register.asp?");
        if (driver.findElement(acceptCookies).isDisplayed()) driver.findElement(acceptCookies).click();
    }

    @Test
    public void checkThatSignUpFormContainsRadioButtonWithLabelIndividual() {
        Assert.assertTrue(driver.findElement(individualAccountLabel).getText()
                .equalsIgnoreCase("Individual"), "The Individual radio button is not present Sign Up");
        log.info("The Individual radio button is present on Sign Up page");
    }

    @Test
    public void checkThatIfNoAccountTypeIsSelectedTheLabelOfTheFirstFieldIsCountry() {
        Assert.assertTrue(driver.findElement(countryFieldLabel).getText()
                .equalsIgnoreCase("Country"), "The label of the first field is not 'Country'");
        log.info("If no account type is selected, the label of the first field is 'Country'");
    }

    @Test
    public void checkThatIfUserTypesSpecificLetterInCountryDropdownTheFieldWillBePopulatedWithTheFirstCountryStartingWithThatLetter() {
        String oneLetter = ServiceUtils.textThatContainsOnly1Letter();
        driver.findElement(countryDropdown).sendKeys(oneLetter);
        driver.findElement(countryDropdown).sendKeys(Keys.ENTER);
        String selectedCountryIndex = new WebDriverWait(driver, Duration.ofMillis(3000))
                .until(ExpectedConditions.presenceOfElementLocated(countryDropdown)).getAttribute("value");
        String selectedCountry = driver.findElement(By.xpath("//option[@value=" + selectedCountryIndex + "]")).getText();
        List<WebElement> listOfCountriesStartingWithSpecificLetter = driver
                .findElements(By.xpath("//option[starts-with(text(), '" + oneLetter + "')]"));
        String firstCountryStartingWithSpecificLetter = listOfCountriesStartingWithSpecificLetter.get(0).getText();
        Assert.assertEquals(firstCountryStartingWithSpecificLetter, selectedCountry,
                "The selected country was not " + firstCountryStartingWithSpecificLetter);

        log.info("The selected country was " + firstCountryStartingWithSpecificLetter);

    }

    @AfterSuite
    public void end() {
        //   driver.close();
        driver.quit();
    }
}


