import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ProductPageTest extends SeleniumTest {

    @Test
    public void getAllPrices() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.loginIn();



        productsPage.sortParseCollectionByASC(); //механически аск
        productsPage.sortParseCollectionDESC(); //механически деск


        productsPage.parsePricesAfterSortASC(); // по фронту натыкал АСК и спарсил цены

        assertion.assertEquals( productsPage.sortParseCollectionByASC(), productsPage.parsePricesAfterSortASC()); //сравнил механическую сортировку и фиическую ASC

        productsPage.parsePricesAfterSortDESC(); // по фронту натыкал DESC и спарсил цены
        assertion.assertEquals(productsPage.sortParseCollectionDESC(), productsPage.parsePricesAfterSortDESC()); //сравнил механическую сортировку и фиическую DESC


// НАПИСАТЬ ГЕТТЕРЫ ШОБ ПРОЩЕ БЫЛО ПИСАТЬ ИБО СИЛЬНО МНОГО ИМЕН

        Thread.sleep(2000);

    }


}
