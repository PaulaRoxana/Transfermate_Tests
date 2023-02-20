package org.example.page_object;

import org.example.utils.TypesOfLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement getElementBy(TypesOfLocators byType, String path, int time) {
        return switch (byType) {
            case ID ->
                    new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
            case NAME ->
                    new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
            case XPATH ->
                    new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            case CSS_SELECTOR ->
                    new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
        };
    }
}
