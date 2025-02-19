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
    private final static By BOOK_DETAILS = By.xpath("/html/body/div[4]/div[3]/div[5]/div/div[1]/div/ul/li[4]/span");
    private final static By BOOK_PREVIEW = By.xpath("(//button[@class='product-action action-info-button'])[1]");
    private final static By GDPR_DECLINE = By.xpath("//button[@class='secondary-gdpr-button']");
    private final static By COVER_TITLE = By.xpath("//*[@id=\"instantpreview-reading-area-container\"]/div[1]/span");

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

    public List<WebElement> searchBookId(String searchBookId) {
        log.info("Search for Book ID: {}", searchBookId);
        actions.clickElement(GDPR_DECLINE);
        actions.sendKeys(SEARCH_FIELD, searchBookId);
        actions.clickElement(SEARCH_BUTTON);
        return actions.getElements(BOOK_DETAILS);
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
}

