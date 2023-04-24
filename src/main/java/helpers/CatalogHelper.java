package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CatalogHelper extends BasePage {

    public CatalogHelper(WebDriver driver) {
        super(driver);
    }

    //locators
    public final By CATALOG_BUTTON = By.xpath("//a[contains(@href, 'catalog') and contains(text(), 'Каталог')]");
    public final By COMPUTER_ITEMS = By.xpath("//div[@data-id='2']//div[contains(@class,'aside-list')]");
    public final By COMPONENT_SUBDIRECTORY_ITEM_NAMES = By.xpath("//div[text()=' Комплектующие ']/..//span[contains(@class, 'title')]");
    public final By COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS = By.xpath("//div[text()=' Комплектующие ']/..//span[3]/text()[1]/..");
    public final By COMPONENT_SUBDIRECTORY_ITEM_PRICE = By.xpath("//div[text()=' Комплектующие ']/..//span//following-sibling::text()[1]/..");
    //public final By ELECTRONIC_ITEMS = By.xpath("//div[@data-id='1']//div[contains(@class,'aside-list')]");
    public final By PRODUCT_PAGE_TITLE_XPATH_PATTERN = By.xpath("//*[contains(@class, 'header_title') and contains(text(), '%s')]");
    //methods
    public void chooseCatalogItem (int id) {
        driver.findElement(By.xpath("//li[@data-id='"+id+"']")).click();
    }

    public void chooseComputerSubdirectory (String name) {
        driver.findElement(By.xpath("//div[text()=' "+name+" ']/..")).click();
    }

    public List<String> getCatalogItems(){
        List <String> items = new ArrayList<>();
        driver.findElements(xpath("//span[@class='catalog-navigation-classifier__item-title']/span"))
                .forEach((WebElement item)-> items.add(item.getText()));
        return items.subList(1, 10);
    }

    public List<String> getItemsFromComputersBlock(){
        List <String> items = new ArrayList<>();
        driver.findElements(xpath("//div[@data-id='2']//div[contains(@class, 'title')]"))
                .forEach((WebElement item)-> items.add(item.getText()));
        return items;
    }

    public void chooseElectronicSubderictory (String name) {
        driver.findElement(By.xpath("//div[text()=' "+name+" ']/..")).click();
    }

    /*public void chooseProductLink (String link) {
        driver.findElement(By.xpath("//*[@id="container"]/div/div/div/div/div[1]/div[4]/div/div[2]/div[1]/div/div[4]/div[2]/div/a[1]/span"));
    }*/
}
