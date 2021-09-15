import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion; // как посмотреть классы и методы в иде

//Почистить джинюнит + сделать проверку логин паге
// почейнить методы что имел тип класса


public class LoginPage {
    WebDriver driver;

    //КОНСТРУКТОРЫ
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage() {

    }
    // ОБЪЕКТЫ
    //  Assertion assert1 = new Assertion();  // ОБЪЕКТЫ
    //   WebDriverWait waiter = new WebDriverWait(driver, 10);

    //ЛОГИН ПАРОЛЬ:
    private String loginValue = "standard_user";
    private String passwordValue = "secret_sauce";

    //ЛОКАТОРЫ:
//    WebElement loginField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
//    WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
//    WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

    //   ЛОКАТОРЫ 2.0
    private final By loginField1 = By.xpath("//*[@id=\"user-name\"]");
    private final By passwordField1 = By.xpath("//*[@id=\"password\"]");
    private final By submitButton1 = By.xpath("//*[@id=\"login-button\"]");
    private final By headerTittle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");



    //МЕТОДЫ:
    public String getLoginName() {
        return loginValue;
    }

    public String getPassword() {
        return passwordValue;
    }

    public void enterLoginName() {
        driver.findElement(loginField1)
                .sendKeys(getLoginName());
    }

    public void enterPassword() {
        driver.findElement(passwordField1)
                .sendKeys(getPassword());
    }

    public void submitButton() {
        driver.findElement(submitButton1).click();
    }

    public void loginIn() throws InterruptedException {
        enterLoginName();
        enterPassword();
        submitButton();
        Assertion assertion = new Assertion();
        String productPageTittle = "PRODUCTS";
        assertion.assertEquals(productPageTittle,driver.findElement(headerTittle).getText());
        Thread.sleep(2000);
    }


}

