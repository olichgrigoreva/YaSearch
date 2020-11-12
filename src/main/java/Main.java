import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    private WebDriver driver;

    @BeforeSuite
    public void initDriver() throws Exception {
        System.out.println("You are testing in Chrome");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchTestNGInGoogle() {
        final String searchKey = "ноутбук xiaomi redmibook";

        driver.navigate().to("https://yandex.ru/");
        WebElement yaMarket = driver.findElement(By.cssSelector("[data-id='market']"));
        yaMarket.click();
        System.out.println("Search '" + searchKey + "' on Yandex market");

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement searchConsole = driver.findElement(By.name("text"));
        System.out.println("Enter " + searchKey);
        searchConsole.sendKeys(searchKey);
        System.out.println("Submit");
        searchConsole.submit();

        WebElement localOffers = driver.findElement(By.xpath("//div//label"));
        localOffers.click();
        System.out.println("Check checkbox");

        String path = System.getProperty("user.dir") + "\\src\\main\\java\\";
        String screenshotName = "screenshot.jpg";

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(),"JPG", new File(path + screenshotName));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println("End of test");
    }

    @AfterSuite
    public void quitDriver() throws Exception {
        driver.quit();
    }
}
