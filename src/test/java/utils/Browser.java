package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getCurrentDriver() {
        if (driver == null) {
            try {
                driver = new ChromeDriver();
                wait = new WebDriverWait(driver, 30);
                maximizeBrowser();
                setPageLoadTimeout();
            } catch (Exception e) {
                System.out.print("Error: " + e.toString());
            }
        }
        return driver;
    }

    private static void setPageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    private static void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    public static void loadUrl(String url) {
        getCurrentDriver().get(url);
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            driver = null;
        } catch (UnreachableBrowserException e) {

        }

    }

}
