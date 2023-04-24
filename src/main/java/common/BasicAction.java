package common;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static java.time.Duration.*;

public class BasicAction {

    public static WebDriver driver;

    public static WebDriver createDriver() {
        BasicConfigurator.configure();
        System.setProperty("webdriver.chrome.driver", "/Users/irina/Downloads/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(EXPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}