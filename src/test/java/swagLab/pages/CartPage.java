package swagLab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Method is used to get tittle of the product added to the Cart. Return String.
     */

    public String getProductTittleCart() {
        return driver.findElement(By.id("item_2_title_link"))
                .findElement(By.className("inventory_item_name"))
                .getText();
    }


    /**
     * Method is used to get price of the product added to the Cart. Return String.
     */
    public String getProductPriceCart() {
        return driver.findElement(By.className("inventory_item_price"))
                .getText();
    }


    /**
     * Method is used to get description of the product added to the Cart. Return String.
     */
    public String getProductDescriptionCart() {
        return driver.findElement(By.className("inventory_item_desc"))
                .getText();
    }
}
