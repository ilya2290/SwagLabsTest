package swagLab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion; // как посмотреть классы и методы в иде

//Почистить джинюнит + сделать проверку логин паге
// почейнить методы что имел тип класса


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Login and password data **/
    private String loginValue = "standard_user";
    private String passwordValue = "secret_sauce";


  /** Locators of elements **/
    private final By loginField1 = By.xpath("//*[@id=\"user-name\"]");
    private final By passwordField1 = By.xpath("//*[@id=\"password\"]");
    private final By submitButton1 = By.xpath("//*[@id=\"login-button\"]");
    private final By headerTittle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");



    /** This method is used to get Login name **/
    public String getLoginName() {
        return loginValue;
    }

    /** This method is used to get Password **/
    public String getPassword() {
        return passwordValue;
    }

    /** This method is used to enter login in the Login field **/
    public void enterLoginName() {
        driver.findElement(loginField1)
                .sendKeys(getLoginName());
    }

    /** This method is used to enter password in the login field */
    public void enterPassword() {
        driver.findElement(passwordField1)
                .sendKeys(getPassword());
    }

    /** This method is used to click on the "Submit" button **/
    public void submitButton() {
        driver.findElement(submitButton1).click();
    }

    /**This method is used to Log in "https://www.saucedemo.com/" like a standard user **/
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

