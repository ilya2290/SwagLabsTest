package swagLab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import java.util.stream.Collectors;

public class ProductsPage {

    private final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    private final By filterButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");
    private final By addToCartButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"); //SAUSE
    private final By productOnesie = By.xpath("//*[@id=\"inventory_container\"]/div/div[5]");
    private final By cartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a"); //


    /**
     * Method is used to remove Char at the string. Return String.
     */
    public static String removeCharAtString(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }


    /**
     * Method is used to parse the price of each product to List. Return List<Double>.
     */
    public List<Double> parseAllPrices() {
        List<String> listOfPricesString = new ArrayList<>();
        List<Double> listOfPricesDouble;
        List<WebElement> listOfPricesWebElements;
        listOfPricesWebElements = driver.findElements(By.className("inventory_item_price"));
        for (WebElement web : listOfPricesWebElements) {
            String text;
            text = web.getText();
            listOfPricesString.add(removeCharAtString(text, 0));
        }
        listOfPricesDouble = listOfPricesString
                .stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        return listOfPricesDouble;
    }


    /**
     * Method is used to GET List with all parsed prices. Return List<Double>.
     */
    public List<Double> getAllParsedPrices() {
        return parseAllPrices();
    }


    /**
     * Method is used to sort the Price to "low to high" by using Collection. Return List<Double>.
     */
    public List<Double> getParseCollectionByASC() {
        List<Double> sortedListASC = new ArrayList<>(getAllParsedPrices());
        Collections.sort(sortedListASC);
        return sortedListASC;
    }


    /**
     * Method is used to sort the Price to "high to low" by using Collection. Return List<Double>.
     */
    public List<Double> getParseCollectionByDESC() {
        List<Double> sortedListDESC = new ArrayList<>(getAllParsedPrices());
        Collections.sort(sortedListDESC);
        Collections.reverse(sortedListDESC);
        return sortedListDESC;
    }


    /**
     * Method is used to set Price sorts to "low to high" by using Driver. Return ProductsPage object.
     */
    public ProductsPage sortPriceByASC() {
        Select select = new Select(driver.findElement(filterButton));
        select.selectByValue("lohi");
        return this;
    }


    /**
     * Method is used to set Price sorts to "high to low" by using Driver. Return ProductsPage object.
     */
    public ProductsPage sortPriceByDESC() {
        Select select = new Select(driver.findElement(filterButton));
        select.selectByValue("hilo");
        return this;
    }


    /**
     * Method is used to set Price sorts to "low to high" by using Driver and parse it to the List. Return List<Double>.
     */
    public List<Double> getPricesByASC() {
        sortPriceByASC();
        return getAllParsedPrices();
    }


    /**
     * Method is used to set Price sorts to "high to low" by using Driver and parse it to the List. Return List<Double>.
     */
    public List<Double> getPricesByDESC() {
        sortPriceByDESC();
        return getAllParsedPrices();
    }


    /**
     * Method is used to get tittle of the product. Return String.
     */
    public String getProductTittle() {
        String productTittle;
        assert driver != null;
        productTittle = driver.findElement(productOnesie)
                .findElement(By.className("inventory_item_name"))
                .getText();
        return productTittle;
    }

    /**
     * Method is used to get description of the product. Return String.
     */
    public String getProductDescription() {
        String productDescription;
        assert driver != null;
        productDescription = driver.findElement(productOnesie)
                .findElement(By.className("inventory_item_desc"))
                .getText();
        return productDescription;
    }


    /**
     * Method is used to get price of the product. Return String.
     */
    public String getProductPrice() {
        String productPrice;
        assert driver != null;
        productPrice = driver.findElement(productOnesie)
                .findElement(By.className("inventory_item_price"))
                .getText();
        return productPrice;
    }


    /**
     * Method is used to add product to cart via "Add to Cart" button. Return void.
     */
    public void addToCartProduct() {
        driver.findElement(addToCartButton)
                .click();
    }


    /**
     * Method is used to open Cart page by clicking on cart icon. Return void.
     */
    public void openCartPage() {
        driver.findElement(cartIcon).click();
    }

}
