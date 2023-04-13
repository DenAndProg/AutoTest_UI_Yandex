package Methods;

import InitialDriver.InitialDriver;
import Wait.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Methods {

    public static void findElementAndClick(By locator){
        Wait.waitElementToClick(locator).click();
    }

    public static void inputText(By locator, String text){
        Wait.waitElement(locator).sendKeys(text);
    }

    public static WebDriver getMainPage(String name) {   //возможно удалю в будущем
        InitialDriver.driver = InitialDriver.getDriver(name);
        assert InitialDriver.driver != null;
        InitialDriver.driver.get("https://yandex.by/");
        return InitialDriver.driver;
    }

    public static void findElementClickAndWent(By locator, int pos){
        findElementAndClick(locator);
        ManageMeth.setWindowHandels(pos);
    }
}
