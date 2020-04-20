package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Browser;

public class BasePage extends Browser {

    public static boolean waitElement(String type, String locator) {
        switch (type) {
            case "id":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                return true;

            case "xpath":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                return true;

            case "className":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
                return true;

            case "linkText":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
                return true;

            case "tagName":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
                return true;


        }
        return false;
    }
}
