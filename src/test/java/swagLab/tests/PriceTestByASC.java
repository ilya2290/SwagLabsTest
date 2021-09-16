package swagLab.tests;

import org.testng.annotations.Test;
import swagLab.driverInit.SeleniumTest;
import swagLab.pages.LoginPage;
import swagLab.pages.ProductsPage;

public class PriceTestByASC extends SeleniumTest  {

    @Test(groups = "filterTest")
    public void priceTestByASC() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.loginIn();
        productsPage.getPricesByASC();
        productsPage.getParseCollectionByASC();
        assertion.assertEquals(productsPage.getParseCollectionByASC(), productsPage.getPricesByASC());
    }
}
