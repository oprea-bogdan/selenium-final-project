import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginKobo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class KoboLoginTest {

    LoginKobo login = new LoginKobo();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        login.openLoginKobo();
    }

    @Test
    @DisplayName("Verify if error messages are displayed")
    public void loginKobo() {
        log.info("Verify if error messages are displayed");
        login.signInKobo();
        login.errorDisplayed();
        assertTrue(login.errorDisplayed(), "Error message is not displayed");

    }

    @Test
    @DisplayName("Verify if the privacy policy is accessible")
    public void privacyPolicy() {
        log.info("Verify if the privacy policy is accessible");
        login.clickPrivacyPolicy();
        login.getPrivacyPolicy();
        String subtitle = login.getPrivacyPolicy();
        assertEquals("1. Collection of personal information", subtitle, "Title of page was: " + subtitle);
    }

    @Test
    @DisplayName("Verify if the Header is displayed")
    public void headerDisplayed() {
        log.info("Verify if the Header is displayed");
        login.isHeaderDisplayed();
    assertTrue(login.isHeaderDisplayed(), "Header is not displayed");
    }


    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }


}
