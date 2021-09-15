import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

public class ProductsPage {

    //VALUES:
    WebDriver driver; // решить вопрос приватный

    ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS:
    private final By filterButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");


    //STATIC METHOD
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    //PRIVATE METHODS - Парс товаров с сортировкой по умолчанию
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

    // Вывод листа с сортировкой по умолчанию ИСПРАВИТь
    public void getParseCollectionByDef(){
        List<Double> sortedListASC = new ArrayList<>(parseAllPricesDefaultSort());
        System.out.println(sortedListASC);
    }

    // Сортировка полученной коллекции по ASC
    public List<Double> sortParseCollectionByASC() {
        List<Double> sortedListASC = new ArrayList<>(parseAllPricesDefaultSort());
        Collections.sort(sortedListASC);
        System.out.println(sortedListASC);
        return sortedListASC;
    }

    // Сортировка полученной коллекции по ASC ГЕТТЕР
    public List<Double> getSortParseCollectionByASC(){
        return sortParseCollectionByASC();
    }


    // Сортировка полученной коллекции по DESC НАПИСАТЬ ГЕТТЕР ИЛИ ПЕРВЫЙ УДАЛИТЬ ГДЕ АСК
    public List <Double> sortParseCollectionDESC() {
        List<Double> sortedListDESC = new ArrayList<>(parseAllPricesDefaultSort());
        Collections.sort(sortedListDESC);
        Collections.reverse(sortedListDESC);
        System.out.println(sortedListDESC);
        return sortedListDESC;
    }

    // Сортировка товаров по фронту ASC
    public void sortByPriceASC() throws InterruptedException {
        Select select = new Select(driver.findElement(filterButton));
        select.selectByValue("lohi");
        Thread.sleep(3000);
    }

    // Сортировка товаров по фронту DESC
    public void sortByPriceDESC() throws InterruptedException {
        Select select = new Select(driver.findElement(filterButton));
        select.selectByValue("hilo");
        Thread.sleep(3000);
    }

    //ПАРС ЦЕН ПОСЛЕ СОРТИРОВКИ НА ФРОНТЕ ASC (с участием клацанья по фронту)
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


