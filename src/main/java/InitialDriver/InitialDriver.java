package InitialDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InitialDriver {

    public static WebDriver driver;
    public static Logger logger = Logger.getLogger("FrontJava.nose");

    public static WebDriver getDriver(String name){
        logger.log(Level.INFO, "Создается драйвер для " + name);
        if(name.equals("Chrome")){
            return createChrome(name);
        }
        if(name.equals("FireFox")){
            return createFireFox(name);
        }
        return null;
    }

    private static WebDriver createChrome(String name){
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ChromeDriver driver = new ChromeDriver(service);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createFireFox(String name){
        GeckoDriverService service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/geckodriver.exe"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FirefoxDriver driver = new FirefoxDriver(service);
        driver.manage().window().maximize();
        return driver;
    }
}
