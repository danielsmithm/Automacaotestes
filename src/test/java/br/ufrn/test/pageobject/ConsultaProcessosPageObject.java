package br.ufrn.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaProcessosPageObject {

    private WebDriver driver;
    private WebElement radioOptionNomeInteressado;
    private WebElement abaDocumentos;
    private WebElement botaoBusca;

    public ConsultaProcessosPageObject(WebDriver driver) {
        this.driver = driver;

        this.radioOptionNomeInteressado = driver.findElement(By.xpath("//*[@class=\"nome_interessado-div campo-busca\"]"));
        this.abaDocumentos = driver.findElement(By.id("l-processos"));
        this.botaoBusca = driver.findElement(By.xpath("//*[@id=\"processoForm\"]/input[3]"));
    }

    public void buscar() {
        botaoBusca.click();
    }

    public void selecionarCampoNomeInteressado() {
        radioOptionNomeInteressado.click();
    }

    public void acessarAbaProcessos() {
        abaDocumentos.click();
    }

}