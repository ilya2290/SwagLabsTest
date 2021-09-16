package swagLab.tests;

import org.testng.annotations.Test;
import swagLab.driverInit.SeleniumTest;
import swagLab.pages.LoginPage;
import swagLab.pages.ProductsPage;

public class PriceTestByDESC extends SeleniumTest {

    @Test(groups = "filterTest")
    public void priceTestByDESC() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.loginIn();
        productsPage.getPricesByDESC();
        productsPage.getParseCollectionByDESC();
        assertion.assertEquals(productsPage.getParseCollectionByDESC(), productsPage.getPricesByDESC());
    }
}
