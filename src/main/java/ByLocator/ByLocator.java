package ByLocator;

import org.openqa.selenium.By;

public class ByLocator {

    public static By login = By.xpath("//*[@id=\"passp-field-login\"]");

    public static By password = By.xpath("//*[@id=\"passp-field-passwd\"]");

    public static By signIn = By.xpath("//*[@id=\"passp:sign-in\"]");

    public static By close = By.xpath("/html/body/div[4]/div/div/div/div/div/div[5]");
}
