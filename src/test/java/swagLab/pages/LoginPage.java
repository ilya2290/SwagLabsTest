package swagLab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;

public class LoginPage {

   private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Login and password data
     **/
    private String loginValue = "standard_user";
    private String passwordValue = "secret_sauce";


    /**
     * Locators of elements
     **/
    private final By loginField1 = By.xpath("//*[@id=\"user-name\"]");
    private final By passwordField1 = By.xpath("//*[@id=\"password\"]");
    private final By submitButton1 = By.xpath("//*[@id=\"login-button\"]");
    private final By headerTittle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");


    /**
     * Method is used to get Login name. Return String.
     **/
    public String getLoginName() {
        return loginValue;
    }


    /**
     * Method is used to get Password. Return String.
     **/
    public String getPassword() {
        return passwordValue;
    }


    /**
     * Method is used to enter login in the Login field. Return LoginPage object.
     **/
    public LoginPage enterLoginName() {
        driver.findElement(loginField1)
                .sendKeys(getLoginName());
        return this;
    }


    /**
     * Method is used to enter password in the login field. Return LoginPage object.
     */
    public LoginPage enterPassword() {
        driver.findElement(passwordField1)
                .sendKeys(getPassword());
        return this;
    }


    /**
     * This method is used to click on the "Submit" button. Return void.
     **/
    public void submitButton() {
        driver.findElement(submitButton1).click();
    }


    /**
     * Method is used to Log in like a standard user. Return void.
     **/
    public void loginIn() {
        enterLoginName()
                .enterPassword()
                .submitButton();
        Assertion assertion = new Assertion();
        String productPageTittle = "PRODUCTS";
        assertion.assertEquals(productPageTittle, driver.findElement(headerTittle).getText());
    }
}

