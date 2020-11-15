package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketPage {
    private WebDriver driver;
    private By searchConsole = By.name("text");
    private By localOffers = By.xpath("//div//label");

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public MarketPage(WebDriver driver, By searchConsole, By localOffers) {
        this.driver = driver;
        this.searchConsole = searchConsole;
        this.localOffers = localOffers;
    }

    public By getLocalOffers() {
        return localOffers;
    }

    public void setLocalOffers(By localOffers) {
        this.localOffers = localOffers;
    }

    public By getSearchConsole() {
        return searchConsole;
    }

    public void setSearchConsole(By searchConsole) {
        this.searchConsole = searchConsole;
    }

    public WebElement searchElement() {
        return driver.findElement(searchConsole);
    }

    public void sendRequest(String requestString) {
        WebElement element = driver.findElement(searchConsole);
        element.sendKeys(requestString);
        element.submit();
    }

    public void clickFilter() {
        driver.findElement(localOffers).click();
    }
}
