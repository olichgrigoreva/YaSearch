package tools;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    String path = "\\src\\test\\java\\results\\";
    String mainPath = System.getProperty("user.dir") + path;
    String screenshotName = "screenshot.jpg";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMainPath() {
        return mainPath;
    }

    public void setMainPath(String mainPath) {
        this.mainPath = mainPath;
    }

    public String getScreenshotName() {
        return screenshotName;
    }

    public void setScreenshotName(String screenshotName) {
        this.screenshotName = screenshotName;
    }

    public void takeScreenshot(WebDriver driver){
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "JPG", new File(mainPath + screenshotName));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
