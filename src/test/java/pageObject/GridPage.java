package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class GridPage extends BasePage {
    public String selectVersion = "switch-version-select";
    public String btnAddCustomer = "Add Customer";
    public String fieldSearch = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/input";
    public String checkBox = "//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr[1]/td[1]/input";
    public String btnDelet = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a";
    public String modalDelet = "modal-content";
    public String btnModalDelet = "/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]";


    public void selecionarVersao() {
        waitElement("id", selectVersion);
        Select comboVersion = new Select(driver.findElement(By.id(selectVersion)));
        comboVersion.selectByValue("bootstrap_theme_v4");
    }

    public void clicarAddCustomer() {
        waitElement("linkText", btnAddCustomer);
        driver.findElement(By.linkText(btnAddCustomer)).click();

    }

    public void clicarSearch() {
        waitElement("xpath", fieldSearch);
        driver.findElement(By.xpath(fieldSearch)).sendKeys("Teste Sicredi");
        driver.findElement(By.xpath(fieldSearch)).sendKeys(Keys.ENTER);
    }

    public void clicarCheckboxeDelet() {
        try {
            driver.findElement(By.xpath(checkBox)).click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.findElement(By.xpath(checkBox)).click();
        }

        driver.findElement(By.xpath(btnDelet)).click();
    }

    public void popUpDelet() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.className(modalDelet)));
        driver.findElement(By.xpath(btnModalDelet)).click();
    }


    public void AssertDelet() {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.className(modalDelet)));

    }

}
