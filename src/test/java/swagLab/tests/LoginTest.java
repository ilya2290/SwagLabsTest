package swagLab.tests;

import org.testng.annotations.Test;
import swagLab.driverInit.SeleniumTest;
import swagLab.pages.LoginPage;

public class LoginTest extends SeleniumTest {

    @Test(groups = {})
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIn();
        Thread.sleep(2000);
    }
}

