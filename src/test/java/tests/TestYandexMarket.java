package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.MarketPage;
import tools.TakeScreenshot;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestYandexMarket {
    WebDriver driver;
    IndexPage yaIndex;
    MarketPage yaMarket;
    TakeScreenshot screenshotObj;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Start testing in Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
    }

    @Test
    public void yaMarketScreenshot() {
        yaIndex = PageFactory.initElements(driver, IndexPage.class);
        yaIndex.clickElement();
        System.out.println("Yandex market click");

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        yaMarket = PageFactory.initElements(driver, MarketPage.class);
        yaMarket.sendRequest("ноутбук xiaomi redmibook");
        System.out.println("Search on Yandex market");

        yaMarket.clickFilter();
        System.out.println("Click checkbox");

        screenshotObj = new TakeScreenshot();
        screenshotObj.takeScreenshot(driver);

        System.out.println("End of test");
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }
}
