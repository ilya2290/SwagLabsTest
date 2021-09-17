package swagLab.tests;

import org.testng.annotations.Test;
import swagLab.driverInit.SeleniumTest;
import swagLab.pages.LoginPage;
import swagLab.pages.ProductsPage;

public class BasketTest extends SeleniumTest {

    @Test (groups = "basketTest")
    public void addToCartTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.loginIn();
        productsPage.addToCartBtnClick();
        productsPage.openCartPage();
        Thread.sleep(12000);


    }
}
