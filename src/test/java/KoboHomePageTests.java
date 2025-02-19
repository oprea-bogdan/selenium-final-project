import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.constants.ProductDetails;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KoboHomePageTests {


    HomePage homePage = new HomePage();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        homePage.openHomePage();
    }

    @DisplayName("Search by multiple book titles")
    @ParameterizedTest
    @EnumSource(ProductDetails.class)
    public void searchEnum(ProductDetails product) {
        log.info("Search book titles");
        homePage.searchElement(product.getProduct());
        List<WebElement> results = homePage.getSearchResults();
        assertEquals(12, results.size(), "Number of products is: " + results.size());
        assertTrue(results.get(0).getText().contains(product.getProduct()), "I found item: " + results.get(0).getText());
    }

    @DisplayName("Search by Book Id")
    @Test
    public void searchTest() {
        log.info("Search Book Id");
        homePage.searchBookId("9780465058792");
        homePage.getBookId();
        String bookId = homePage.getBookId();
        assertEquals("9780465058792", bookId, "Book Id is: " + bookId);

    }

    @DisplayName("Search by Book author")
    @Test
    public void searchTestAuthor() {
        log.info("Search Book author");
        homePage.searchElement("Alfred Lansing");
        List<WebElement> results = homePage.getSearchResults();
        assertEquals(12, results.size(), "Number of products is: " + results.size());
        assertTrue(results.get(0).getText().contains("Alfred Lansing"), "I found item: " + results.get(0).getText());
    }


    @DisplayName("Book Preview")
    @Test
    public void bookPreview() {
        log.info("Book Preview");
        homePage.searchBookId("9780465058792");
        homePage.bookPreview();
        homePage.bookPreviewTitle();
        String title = homePage.bookPreviewTitle();
        assertEquals("Endurance", title, "Title of page was: " + title);
    }


//    @AfterEach
//    public void tearDown() {
//        BrowserManager.closeDriver();
//    }
}

