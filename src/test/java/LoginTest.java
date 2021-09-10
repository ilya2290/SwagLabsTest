import org.testng.annotations.Test;

public class LoginTest extends SeleniumTest {

    @Test(groups = {"regressionTests"})
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIn();
        Thread.sleep(2000);
    }
}

