package swagLab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

public class ProductsPage {

    //VALUES:
    WebDriver driver; // решить вопрос приватный

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS:
    private final By filterButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");


    //STATIC METHOD
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    /**
     * This method is used to parse price of each product
     */
    public List<Double> parseAllPricesDefaultSort() {

        List<String> listOfPricesString = new ArrayList<>();
        List<Double> listOfPricesDouble;
        List<WebElement> listOfPricesWebElements;

        listOfPricesWebElements = driver.findElements(By.className("inventory_item_price"));

        for (WebElement web : listOfPricesWebElements) {
            String text;
            text = web.getText();
            listOfPricesString.add(removeCharAt(text, 0));
        }

        listOfPricesDouble = listOfPricesString
                .stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        return listOfPricesDouble;
    }

    /** Вывод листа с сортировкой по умолчанию ИСПРАВИТь
     */
    public List <Double> getParseCollectionByDef(){  //Может быть, что всего лишь нужен будет 1 парс и все, потом вот этим гетом забирать цены с любой сортировкой
        return parseAllPricesDefaultSort();
    }

    /** GET полученной коллекции ПРОГРАММНЫМ путем по ASC */ //Коллекция отсортирована ПРОГРАММНО ПО ВОЗРАСТАНИЮ, мб достаточно 1 ГЕТТЕРА, убрать метод ПРОСТО ОТСОРТИРОВАТЬ а сделать ГЕТТЕР
    public List<Double> getParseCollectionByASC() {
        List <Double> sortedListASC = new ArrayList<>(getParseCollectionByDef());
        Collections.sort(sortedListASC);
        return sortedListASC;
    }


    /** GET полученной коллекции ПРОГРАММНЫМ путем по DESC */
    public List <Double> getParseCollectionByDESC() {
        List<Double> sortedListDESC = new ArrayList<>(getParseCollectionByDef());
        Collections.sort(sortedListDESC);
        Collections.reverse(sortedListDESC);
        return sortedListDESC;
    }

    /** Method is used to set Price sort - "low to high" by Driver*/
    public void sortByPriceASC() throws InterruptedException {
        Select select = new Select(driver.findElement(filterButton));
        select.selectByValue("lohi");
        Thread.sleep(3000);
    }

    /** Method is used to set Price sort - "high to low" by Driver*/
    public void sortByPriceDESC() throws InterruptedException {
        Select select = new Select(driver.findElement(filterButton));
        select.selectByValue("hilo");
        Thread.sleep(3000);
    }

    //ПАРС ЦЕН ПОСЛЕ СОРТИРОВКИ НА ФРОНТЕ ASC (с участием клацанья по фронту) // мб это не надо, просто надо использовать стандартный парс после переключения и все
    public List<Double> parsePricesAfterSortASC() throws InterruptedException {
        sortByPriceASC();

        List<String> listOfPricesString = new ArrayList<>();
        List<Double> listOfPricesDouble;
        List<WebElement> listOfPricesWebElements;

        listOfPricesWebElements = driver.findElements(By.className("inventory_item_price"));

        for (WebElement web : listOfPricesWebElements) {
            String text;
            text = web.getText();
            listOfPricesString.add(removeCharAt(text, 0));
        }

        listOfPricesDouble = listOfPricesString
                .stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println(listOfPricesDouble);
        return listOfPricesDouble;

    }

    //ПАРС ЦЕН ПОСЛЕ СОРТИРОВКИ НА ФРОНТЕ DESC
    public List<Double> parsePricesAfterSortDESC() throws InterruptedException {
        sortByPriceDESC();

        List<String> listOfPricesString = new ArrayList<>();
        List<Double> listOfPricesDouble;
        List<WebElement> listOfPricesWebElements;

        listOfPricesWebElements = driver.findElements(By.className("inventory_item_price"));

        for (WebElement web : listOfPricesWebElements) {
            String text;
            text = web.getText();
            listOfPricesString.add(removeCharAt(text, 0));
        }

        listOfPricesDouble = listOfPricesString
                .stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println(listOfPricesDouble);
        return listOfPricesDouble;
    }


}


