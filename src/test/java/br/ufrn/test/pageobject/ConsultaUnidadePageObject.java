package br.ufrn.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaUnidadePageObject {

    private WebDriver driver;
    private WebElement abaUnidade;
    private WebElement botaoBusca;
    private WebElement campoNome;

    public ConsultaUnidadePageObject(WebDriver driver) {
        this.driver = driver;

        this.abaUnidade = driver.findElement(By.id("l-unidades"));
        this.botaoBusca = driver.findElement(By.xpath("//*[@id=\"unidade\"]/div[2]/input"));
        this.campoNome = driver.findElement(By.id("unidade:nome"));
    }

    public void selecionaAbaUnidade() {
        abaUnidade.click();
    }

    public void preencherNome(String nome) {
        campoNome.sendKeys(nome);
    }

    public void buscar() {
        botaoBusca.click();
    }

}


