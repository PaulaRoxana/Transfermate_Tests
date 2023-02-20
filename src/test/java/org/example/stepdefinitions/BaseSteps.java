package org.example.stepdefinitions;


import browsers.factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


@Slf4j
public class BaseSteps {

    public static WebDriver driver;

    @Before
    public void initWebDriver() {
        driver = new WebDriverFactory().getWebDriver();
        driver.get("https://transfermate.io/en/register.asp?");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

