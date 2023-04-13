package Wait;

import InitialDriver.InitialDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Level;



import static InitialDriver.InitialDriver.logger;

public class Wait {

    public static WebElement waitElement(By locator){
        WebDriverWait wait = new WebDriverWait(InitialDriver.driver, 15); ///сделать лог если нет элемента
        try{
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (NoSuchElementException e){
            System.out.println("Элемент не найден!!!");
            logger.log(Level.INFO, "Элемент не найден!!!");
        }
        return InitialDriver.driver.findElement(locator);
    }

    public static WebElement waitElementToClick(By locator){
        WebDriverWait wait = new WebDriverWait(InitialDriver.driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return InitialDriver.driver.findElement(locator);
    }

    /*public static WebElement waitPage(){
        WebDriverWait wait = new WebDriverWait(InitialDriver.driver, 15);
        wait.until()
    }*/
}
