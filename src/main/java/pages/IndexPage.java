package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {
    private WebDriver driver;
    private By marketIcon = By.cssSelector("[data-id='market']");

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public IndexPage(WebDriver driver, By marketIcon) {
        this.driver = driver;
        this.marketIcon = marketIcon;
    }

    public By getMarketIcon() {
        return marketIcon;
    }

    public void setMarketIcon(By marketIcon) {
        this.marketIcon = marketIcon;
    }

    public WebElement searchElement(){
        return driver.findElement(marketIcon);
    }

    public void clickElement() {
        driver.findElement(marketIcon).click();
    }
}
