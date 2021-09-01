import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    Assertion assert1 = new Assertion();  // ОБЪЕКТЫ
    ChromeDriver driver = new ChromeDriver();

                                                    //ЛОГИН И ПАРОЛЬ
   private String loginValue = "standard_user";
   private String passwordValue = "secret_sauce";


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
    public void login() throws InterruptedException {

        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        String loginValue = "standard_user";
        loginField.sendKeys(loginValue);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        String passwordValue = "secret_sauce";
        passwordField.sendKeys(passwordValue);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        String submitButtonName = "Login";

        System.out.println("Attribute is: "+ submitButton.getAttribute("value"));

        submitButton.click();

        Thread.sleep(1000);

    }
    //WebElement loginField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));

    public String getLoginName( ){
        return loginValue;
    }
    public void setLoginValue(String loginValue){
        this.loginValue = loginValue;
    }

//    public void enterLoginName(){
//        loginField.sendKeys(getLoginName());
//    }


}

