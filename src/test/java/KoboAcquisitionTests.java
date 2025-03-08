import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.AcquisitionKobo;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KoboAcquisitionTests {

    AcquisitionKobo acquisitionKobo = new AcquisitionKobo();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        acquisitionKobo.openAcquisitionKobo();
    }

    @DisplayName("Verify if user cannot wishlist a book without being logged in")
    @Test
    public void wishlistBook() {
        log.info("Wishlist a book without account");
        acquisitionKobo.openEbooksSection();
        acquisitionKobo.getCreateAccountText();
        String signInText = acquisitionKobo.getCreateAccountText();
        assertTrue(signInText.contains("Sign In"), "Text is: " + signInText);
    }

    @DisplayName("Verify if user can add an ebook reader to cart")
    @Test
    public void addEbookReader() {
        log.info("Add ebook reader to cart");
        acquisitionKobo.addReaderToCart();
        acquisitionKobo.payEnabled();
        boolean isPayEnabled = acquisitionKobo.payEnabled();
        assertTrue(isPayEnabled, "Pay is not enabled");
    }


    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }

}
