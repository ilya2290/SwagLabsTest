package swagLab.driverInit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.Assertion;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public WebDriver driver = new ChromeDriver();
    public Assertion assertion = new Assertion();

    @BeforeTest
    public void driverSetup()  {
        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ IDEA Community Edition 2020.2.1\\Chrome Driver\\chromedriver.exe");
        driver.manage().window()
                .maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterTest
    public void driverClose()  {
        driver.close();
    }
}
