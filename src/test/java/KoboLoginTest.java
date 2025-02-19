import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginKobo;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class KoboLoginTest {

    LoginKobo login = new LoginKobo();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        login.openLoginKobo();
    }

    @Test
    @DisplayName("Verify if user can insert email and password")
    public void loginKobo() {
        login.signInKobo();
    }

    @Test
    @DisplayName("Verify if the privacy policy is accessible")
    public void privacyPolicy() {
        login.clickPrivacyPolicy();
        login.getPrivacyPolicy();
        String subtitle = login.getPrivacyPolicy();
        assertEquals("1. Collection of personal information", subtitle, "Title of page was: " + subtitle);
    }

    @Test
    @DisplayName("Verify if the Header is displayed")
    public void headerDisplayed() {
    assertTrue(login.isHeaderDisplayed(), "Header is not displayed");
    }


    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }


}
