package pageObject;

import org.openqa.selenium.By;

public class AddPage extends BasePage {
    public String name = "field-customerName";
    public String lastName = "field-contactLastName";
    public String contactFirstName = "field-contactFirstName";
    public String phone = "field-phone";
    public String addressLine1 = "field-addressLine1";
    public String addressLine2 = "field-addressLine2";
    public String city = "field-city";
    public String state = "field-state";
    public String postalCode = "field-postalCode";
    public String country = "field-country";
    public String salesRepEmployeeNumber = "field_salesRepEmployeeNumber_chosen";
    public String creditLimit = "field-creditLimit";
    public String btnSave = "form-button-save";
    public String btnSaveandBack = "save-and-go-back-button";

    public void preencherForm() {
        waitElement("id", name);

        driver.findElement(By.id(name)).sendKeys("Teste Sicredi");
        driver.findElement(By.id(lastName)).sendKeys("Teste");
        driver.findElement(By.id(contactFirstName)).sendKeys("Giovani");
        driver.findElement(By.id(phone)).sendKeys("51 9999-9999");
        driver.findElement(By.id(addressLine1)).sendKeys("Av Assis Brasil, 3970");
        driver.findElement(By.id(addressLine2)).sendKeys("Torre D");
        driver.findElement(By.id(city)).sendKeys("Porto Alegre");
        driver.findElement(By.id(state)).sendKeys("RS");
        driver.findElement(By.id(postalCode)).sendKeys("91000-000");
        driver.findElement(By.id(country)).sendKeys("Brasil");
        driver.findElement(By.id(salesRepEmployeeNumber)).click();
        driver.findElement(By.id(creditLimit)).sendKeys("200");


    }

    public void clicarBtnSave() {
        driver.findElement(By.id(btnSave)).click();

    }

    public void clicarBtnSaveandBack() {
        driver.findElement(By.id(btnSaveandBack)).click();

    }
}
