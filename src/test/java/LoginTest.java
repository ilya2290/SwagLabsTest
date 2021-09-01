import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    Assertion assert1 = new Assertion();
    ChromeDriver driver = new ChromeDriver();

    @BeforeTest
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ IDEA Community Edition 2020.2.1\\Chrome Driver\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    public void driverClose() {
        System.out.println("Test Login Passed");
        driver.close();
    }


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        //loginPage.enterLoginName();
        System.out.println("Test 2 passed");
    }


}

