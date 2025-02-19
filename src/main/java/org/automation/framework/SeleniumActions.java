package org.automation.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumActions {

    private final BrowserManager browserManager;

    public SeleniumActions(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    public boolean isElementDisplayed(By locator) {
        return browserManager.getDriver().findElement(locator).isDisplayed();
    }

    public String getElementText(By locator) {
        return browserManager.getDriver().findElement(locator).getText();
    }

    public List<WebElement> getElements(By locator) {
        return browserManager.getDriver().findElements(locator);
    }

    public void clickElement(By locator) {
        browserManager.getDriver().findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        browserManager.getDriver().findElement(locator).sendKeys(text);
    }

    public void waitElementToBeClickable(By locator, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitFluentElementVisible(By locator, int timeOut) {
        Wait<WebDriver> wait = new FluentWait<>(browserManager.getDriver())
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
public void waitImplicit(int timeOut) {
        browserManager.getDriver().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public void VK_BACK_SPACE(By locator) {
        browserManager.getDriver().findElement(locator).sendKeys(Keys.BACK_SPACE);
    }

}
