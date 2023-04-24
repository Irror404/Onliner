import common.BasicAction;
import helpers.CatalogHelper;
import org.openqa.selenium.WebDriver;

import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {

    protected  WebDriver driver = BasicAction.createDriver();
    protected CatalogHelper catalogHelper = new CatalogHelper(driver);

    public void close() {
        if(HOLD_BROWSER_OPEN)
        {
            driver.quit();
        }
    }
}
