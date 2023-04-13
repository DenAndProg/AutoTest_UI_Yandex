package ScreenShot;

import InitialDriver.InitialDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class MakeScreen {

    public static void makeScreenShot(String name/*, By locator*/){
        TakesScreenshot screenShot = ((TakesScreenshot) InitialDriver.driver);
        File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
        File DestinationFile = null;
        switch (name){
            case ("Chrome"):{
                DestinationFile = new File("C:\\TestUI\\Chrome\\ScreenChrome.png");
                break;
            }
            case ("FireFox"):{
                DestinationFile = new File("C:\\TestUI\\FireFox\\ScreenFireFox.png");
                break;
            }
            default:{
                System.out.println("Скриншот не сделан, такого браузера нету.");
            }
        }
        try {
            assert (DestinationFile != null);
            FileUtils.copyFile(sourceFile, DestinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
