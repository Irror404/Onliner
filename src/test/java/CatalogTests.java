import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static constants.Constant.Url.ONLINER_START_PAGE;
import static enums.CatalogItems.*;
import static enums.ElectronicSubItem.AUDIO_DEVICE;
import static enums.SubCatalogItems.*;
import static pages.BasePage.open;

public class CatalogTests extends BaseTest {

    static Logger log = Logger.getLogger(CatalogTests.class);

    SoftAssert softly = new SoftAssert();

    @BeforeMethod
    public void openCatalogPage() {
        open(ONLINER_START_PAGE);
        driver.findElement(catalogHelper.CATALOG_BUTTON).click();

    }

    @Test(priority = 3, groups = "catalogTests")
    public void shouldCheckCatalogItems() {
        //given
        List<String> items = new ArrayList<>();
        items.add(ELECTRONIC.getText());
        items.add(COMPUTERS.getText());
        items.add(HOUSEHOLD_APPLIANCE.getText());
        items.add(FOR_EVERY_DAY.getText());
        items.add(BUILDIND_AND_REPAIR.getText());
        items.add(HOME_AND_GARDEN.getText());
        items.add(AUTO_AND_MOTO.getText());
        items.add(BEAUTY_AND_SPORT.getText());
        items.add(CHILDREN_AND_MOTHERS.getText());
        //then
        softly.assertEquals(catalogHelper.getCatalogItems(), items);

    }

    @Test(priority = 1, groups = "catalogTests")
    public void shouldCheckComputerCatalog() {
        //given
        int id= 2;
        List<String> items = new ArrayList<>();
        items.add(LAPTOPS_COMPUTERS_MONITORS.getText());
        items.add(ACCESSORIES.getText());
        items.add(DATA_STORAGE.getText());
        items.add(NETWORK_EQUIPMENT.getText());
        //when
        catalogHelper.chooseCatalogItem(id);
        //then
        softly.assertTrue(driver.findElement(catalogHelper.COMPUTER_ITEMS).isDisplayed());
        softly.assertTrue(catalogHelper.getItemsFromComputersBlock().containsAll(items));
        softly.assertAll();
    }

    @Test(priority = 2, groups = "catalogTests")
    public void shouldCheckComponentsSubdirectory() {
        //given
        int id = 2;
        //when
        catalogHelper.chooseCatalogItem(id);
        catalogHelper.chooseComputerSubdirectory(ACCESSORIES.getText());
        //then
        softly.assertTrue(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_NAMES).stream().allMatch(WebElement::isDisplayed));
        softly.assertTrue(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS).stream().allMatch(WebElement::isDisplayed));
        softly.assertTrue(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_PRICE).stream().allMatch(WebElement::isDisplayed));
        softly.assertAll();
    }

   /* @Test(priority = 4, groups = "catalogTests")
    public void shouldCheckProductItems() {
        //given
        int id = 1;
        List<String> items = new ArrayList<>();
        items.add(AUDIO_DEVICE.getText());
        //when
        catalogHelper.chooseCatalogItem(id);
        catalogHelper.chooseElectronicSubderictory(AUDIO_DEVICE.getText());
        softly.assertTrue(catalogHelper.findElements);
    }*/

    @AfterClass(groups = "catalogTests", alwaysRun = true)
    public void closeBrowser() {
        close();
    }
}
