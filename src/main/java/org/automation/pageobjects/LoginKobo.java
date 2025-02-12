package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.constants.SignInDetails;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

public class LoginKobo {
    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);


    private final static By EMAIL_ADDRESS_FIELD = By.xpath("//input[@placeholder='Email address']");
    private final static By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private final static By SIGNIN_BUTTON = By.xpath("//button[@class='primary-action sign-in-cta']");
    private final static By MYACCOUNT_BUTTON = By.xpath("//button[@title='My Account']");

    public void openLoginKobo() {
        log.info("Open Kobo signin page");
        manager.openBrowser();
        manager.getDriver().get("https://authorize.kobo.com/ro/en/Signin?returnUrl=https%3a%2f%2fwww.kobo.com%2f");
        manager.getDriver().manage().window().maximize();
    }

    public void signInKobo() {
        log.info("SignIn to Kobo page");
        String user = SignInDetails.SIGNIN_USER.getUsername();
        String pass = SignInDetails.SIGNIN_USER.getPassword();


        actions.sendKeys(EMAIL_ADDRESS_FIELD, user);
        actions.sendKeys(PASSWORD_FIELD, pass);
        actions.clickElement(SIGNIN_BUTTON);

    }

    public boolean isMyAccountDisplayed() {
        log.info("Check if My Account button is displayed");
        return actions.isElementDisplayed(MYACCOUNT_BUTTON);
    }
}

