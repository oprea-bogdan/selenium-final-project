package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.rolling.action.DeleteAction;
import org.automation.constants.SignInDetails;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.Keys.BACK_SPACE;

public class LoginKobo {
    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);


    private final static By EMAIL_ADDRESS_FIELD = By.xpath("//input[@placeholder='Email address']");
    private final static By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private final static By SHOW_PASSWORD_BUTTON = By.xpath("//span[@class='show-text']");
    private final static By VISIBLE_PASSWORD = By.xpath("//*[@id=\"providerSignIn\"]/form");
    private final static By SIGN_IN_BUTTON = By.xpath("//*[@id=\"signInBlock\"]/button");
    private final static By PRIVACY_POLICY_BUTTON = By.xpath("//a[@class='kobo-link privacy-policy']");
    private final static By PRIVACY_POLICY = By.xpath("//*[@id=\"main-privacy-policy\"]/div/h4[1]");
    private final static By HEADER = By.xpath("//div[@class='header-logo kobo-header-logo ']");
    private final static By PASSWORD_ERROR = By.xpath("//*[@id=\"error-message-password\"]/span");

    public void openLoginKobo() {
        log.info("Open Kobo login page");
        manager.openBrowser();
        manager.getDriver().get("https://authorize.kobo.com/ro/en/signin/signin/kobo?workflowId=20929809-b392-4d73-bbe7-a64d4aba061b");
        manager.getDriver().manage().window().maximize();
    }

    public void signInKobo() {
        log.info("Insert credentials");

        String email = SignInDetails.SIGNIN_USER.getUsername();
        String pass = SignInDetails.SIGNIN_USER.getPassword();

        actions.sendKeys(EMAIL_ADDRESS_FIELD, email);
        actions.clickElement(SIGN_IN_BUTTON);
    }

    public boolean errorDisplayed() {
        log.info("Password error displayed");
        return actions.isElementDisplayed(PASSWORD_ERROR);
    }

    public void clickPrivacyPolicy() {
        log.info("Open Privacy Policy");
        actions.clickElement(PRIVACY_POLICY_BUTTON);;
    }

    public String getPrivacyPolicy() {
        log.info("Get Privacy Policy");
        return actions.getElementText(PRIVACY_POLICY);
    }

    public boolean isHeaderDisplayed() {
        log.info("Check if header is displayed");
        return actions.isElementDisplayed(HEADER);
    }


}

