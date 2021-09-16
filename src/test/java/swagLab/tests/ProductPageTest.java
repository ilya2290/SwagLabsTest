package swagLab.tests;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import swagLab.driverInit.SeleniumTest;
import swagLab.pages.LoginPage;
import swagLab.pages.ProductsPage;

public class ProductPageTest extends SeleniumTest {

    @Test
    public void getAllPrices() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.loginIn();

        Assertion assertion = new Assertion();

        productsPage.getParseCollectionByASC(); //механически аск
        productsPage.getParseCollectionByDESC(); //механически деск


        productsPage.parsePricesAfterSortASC(); // по фронту натыкал АСК и спарсил цены

        assertion.assertEquals( productsPage.getParseCollectionByASC(), productsPage.parsePricesAfterSortASC()); //сравнил механическую сортировку и фиическую ASC

        productsPage.parsePricesAfterSortDESC(); // по фронту натыкал DESC и спарсил цены
        assertion.assertEquals(productsPage.getParseCollectionByDESC(), productsPage.parsePricesAfterSortDESC()); //сравнил механическую сортировку и фиическую DESC


// НАПИСАТЬ ГЕТТЕРЫ ШОБ ПРОЩЕ БЫЛО ПИСАТЬ ИБО СИЛЬНО МНОГО ИМЕН

        Thread.sleep(2000);

    }


}
