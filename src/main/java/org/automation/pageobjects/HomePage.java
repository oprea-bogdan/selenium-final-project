package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By SEARCH_FIELD = By.xpath("//input[@id='sl']");
    private final static By SEARCH_BUTTON = By.xpath("(//input[@value='submit'])[1]");
    private final static By SEARCH_RESULTS = By.xpath("//div[@data-testid='book-card-search-result-items']");
    private final static By BOOK_DETAILS = By.xpath("/html/body/div[3]/div[3]/div[5]/div/div[1]/div/ul/li[4]/span");
    private final static By BOOK_PREVIEW = By.xpath("(//button[@class='product-action action-info-button'])[1]");
    private final static By GDPR_DECLINE = By.xpath("//button[@class='secondary-gdpr-button']");
    private final static By COVER_TITLE = By.xpath("//*[@id=\"instantpreview-reading-area-container\"]/div[1]/span");
    private final static By CREATE_ACCOUNT = By.xpath("//a[@aria-label='Create account']");
    private final static By EMAIL_ADDRESS = By.xpath("//input[@aria-label='Email address']");
    private final static By CONFIRM_EMAIL = By.xpath("//input[@aria-label='Confirm email address']");
    private final static By PASSWORD = By.xpath("//input[@aria-label='Password']");
    private final static By CONTINUE_BUTTON = By.xpath("//*[@id=\"registerBlock\"]/button");
    private final static By EMAIL_ERROR = By.xpath("//span[@for='RegisterByCredentialsModel_UserName']");
    private final static By CONFIRM_EMAIL_ERROR = By .xpath("//span[@for='RegisterByCredentialsModel_ConfirmUserName']");
    private final static By PASSWORD_ERROR = By .xpath("//span[@for='RegisterByCredentialsModel_Password']");

    public void openHomePage() {
        log.info("Open Kobo home page");
        manager.openBrowser();
        manager.getDriver().get("https://www.kobo.com/ro/en");
        manager.getDriver().manage().window().maximize();
    }

    public void searchElement(String searchElement) {
        log.info("Search for element: {}", searchElement);
        actions.clickElement(GDPR_DECLINE);
        actions.waitFluentElementVisible(SEARCH_FIELD, 5);
        actions.sendKeys(SEARCH_FIELD, searchElement);
        actions.waitElementToBeClickable(SEARCH_BUTTON, 10);
        actions.clickElement(SEARCH_BUTTON);
        actions.isElementDisplayed(SEARCH_RESULTS);
    }

    public void searchBookId(String searchBookId) {
        log.info("Search for Book ID: {}", searchBookId);
        actions.clickElement(GDPR_DECLINE);
        actions.sendKeys(SEARCH_FIELD, searchBookId);
        actions.clickElement(SEARCH_BUTTON);
    }

    public String getBookId() {
        log.info("Get book ID title");
        return actions.getElementText(BOOK_DETAILS);
    }

    public void bookPreview() {
        log.info("Click on book preview");
        actions.clickElement(BOOK_PREVIEW);
    }

    public String bookPreviewTitle() {
        log.info("Get book preview title");
        actions.waitFluentElementVisible(COVER_TITLE, 10);
        return actions.getElementText(COVER_TITLE);
    }

    public List<WebElement> getSearchResults() {
        return actions.getElements(SEARCH_RESULTS);
    }

    public void setCreateAccount() {
        log.info("Create Account");
        actions.clickElement(CREATE_ACCOUNT);
        actions.clickElement(CONTINUE_BUTTON);
    }

    public boolean createAccountErrors() {
        log.info("Check if errors are displayed");
        return actions.isElementDisplayed(EMAIL_ERROR) && actions.isElementDisplayed(CONFIRM_EMAIL_ERROR) && actions.isElementDisplayed(PASSWORD_ERROR);
    }

}

