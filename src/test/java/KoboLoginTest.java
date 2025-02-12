import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginKobo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KoboLoginTest {

    LoginKobo login = new LoginKobo();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        login.openLoginKobo();
    }

    @Test
    @DisplayName("SignIn to Kobo test")
    public void signInTest() {
        login.signInKobo();
    }



//    @AfterEach
//    public void tearDown() {
//        BrowserManager.closeDriver();
//    }


}
