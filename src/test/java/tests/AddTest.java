package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.AddPage;
import pageObject.BasePage;
import pageObject.GridPage;
import utils.Browser;
import utils.Utils;


public class AddTest {

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.webDriverLocation());
        Browser.loadUrl(Utils.getBaseUrl());
    }

    GridPage gridPage = new GridPage();
    AddPage addPage = new AddPage();

    @Test
    public void desafio1() {
        String mensagem = "report-success";


        gridPage.selecionarVersao();
        gridPage.clicarAddCustomer();
        addPage.preencherForm();
        addPage.clicarBtnSave();

        BasePage.waitElement("id", mensagem);

        //No site o texto é: "Your data has been successfully stored into the database. Edit Customer or Go back to list"
        //então tive que usar substring para pegar só a parte que a prova dizia: "Your data has been successfully stored into the database."
        String sucesso = Browser.driver.findElement(By.id(mensagem)).getText().substring(0, 57);

        Assert.assertEquals(sucesso, "Your data has been successfully stored into the database.");

        Browser.close();
    }

    @Test
    public void desafio2() {
        setup();

        String mensagemPopUp = "/html/body/div[2]/div[2]/div[3]/div/div/div[2]";
        String DeleteSucesso = "/html/body/div[3]/span[3]/p";


        gridPage.selecionarVersao();
        gridPage.clicarAddCustomer();
        addPage.preencherForm();
        addPage.clicarBtnSaveandBack();
        gridPage.clicarSearch();
        gridPage.clicarCheckboxeDelet();
        gridPage.popUpDelet();


        BasePage.waitElement("xpath", mensagemPopUp);
        String delet = Browser.driver.findElement(By.xpath(mensagemPopUp)).getText();
        Assert.assertEquals(delet, "Are you sure that you want to delete this 1 item?");


        BasePage.waitElement("xpath", DeleteSucesso);
        String deleteSuccess = Browser.driver.findElement(By.xpath(DeleteSucesso)).getText();
        Assert.assertEquals(deleteSuccess,
                "Your data has been successfully deleted from the database.");

    }

     @AfterClass public void tearDown(){
    Browser.close();
    }
}
