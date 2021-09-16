package swagLab.tests;

import org.testng.annotations.Test;
import swagLab.driverInit.SeleniumTest;
import swagLab.pages.LoginPage;

public class LoginTest extends SeleniumTest {

    @Test(groups = "regression")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIn();
    }
}

