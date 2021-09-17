package swagLab.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import swagLab.driverInit.SeleniumTest;
import swagLab.pages.CartPage;
import swagLab.pages.LoginPage;
import swagLab.pages.ProductsPage;

public class BasketTest extends SeleniumTest {

    @Test(groups = "basketTest")
    public void addToCartTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.loginIn();

        String productTittle = productsPage.getProductTittle();   //Save in variables the values of the title, description, product price on the Product Page.
        String productPrice = productsPage.getProductPrice();
        String productDescription = productsPage.getProductDescription();

        productsPage.addToCartProduct();
        productsPage.openCartPage();

       String expectedCartHeaderName = "YOUR CART";
       String actualCartHeaderName = driver.findElement(By.className("title")).getText();

       assertion.assertEquals(expectedCartHeaderName, actualCartHeaderName); // Checking that this is the cart page

        String productTittleCart = cartPage.getProductTittleCart(); //Save in variables the values of the title, description, product price on Cart Page.
        String productPriceCart = cartPage.getProductPriceCart();
        String productDescriptionCart = cartPage.getProductDescriptionCart();

        assertion.assertEquals(productTittle, productTittleCart); //Checking for matching titles
        assertion.assertEquals(productDescription, productDescriptionCart); //Checking for matching descriptions
        assertion.assertEquals(productPrice, productPriceCart); //Checking for matching prices
    }
}
