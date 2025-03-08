package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

public class AcquisitionKobo {
    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By EBOOKS_SECTION = By.xpath("//button[@id='shop-ebooks']");
    private final static By RANDOM_PRODUCT = By.xpath("(//div[@class='item-container '])[3]");
    private final static By ADD_TO_WISHLIST = By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/div[2]/div/div/div[3]/button[3]");
    private final static By SIGN_IN_PAGE = By.xpath("//*[@id=\"defaultOptions\"]/h1");
    private final static By GDPR_DECLINE = By.xpath("//button[@class='secondary-gdpr-button']");
    private final static By EREADER = By.xpath("//*[@id=\"link-nav-showdevices\"]");
    private final static By SEARCH_EREADER_BUTTON = By.xpath("//a[@class='browse']");
    private final static By PRODUCT_DETAILS = By.xpath("(//a[@class='w-fc button-primary '])[2]");
    private final static By ADD_TO_CART = By.xpath("//*[@id=\"AddToCart\"]");
    private final static By CART = By.xpath("//div[@class='site-header-cart']");
    private final static By PAY_BUTTON= By.xpath("(//button[@name='checkout'])[1]");

    public void openAcquisitionKobo() {
        log.info("Open Kobo home page");
        manager.openBrowser();
        manager.getDriver().get("https://www.kobo.com/ro/en");
        manager.getDriver().manage().window().maximize();
    }

    public void openEbooksSection() {
        log.info("Add eBook to wishlist");
        actions.clickElement(GDPR_DECLINE);
        actions.hoverElement(EBOOKS_SECTION, manager.getDriver());
        actions.clickElement(EBOOKS_SECTION);
        actions.clickElement(RANDOM_PRODUCT);
        actions.clickElement(ADD_TO_WISHLIST);
        actions.waitFluentElementVisible(SIGN_IN_PAGE, 5);
    }

    public String getCreateAccountText() {
        log.info("Get Create Account text");
        return actions.getElementText(SIGN_IN_PAGE);
    }

    public void addReaderToCart() {
        log.info("Add reader to cart");
        actions.clickElement(GDPR_DECLINE);
        actions.hoverElement(EREADER, manager.getDriver());
        actions.waitFluentElementVisible(EREADER, 5);
        actions.clickElement(EREADER);
        actions.waitImplicit(2);
        actions.clickElement(EREADER);
        actions.clickElement(SEARCH_EREADER_BUTTON);
        actions.clickElement(PRODUCT_DETAILS);
        actions.clickElement(ADD_TO_CART);
        actions.clickElement(CART);
    }

    public boolean payEnabled() {
        log.info("Check if the product is added to the cart and payment button is enabled");
        return actions.isElementEnabled(PAY_BUTTON);

    }


}
