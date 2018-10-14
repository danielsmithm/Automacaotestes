package br.ufrn.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaDocumentosPageObject {

    private WebDriver driver;
    private WebElement radioOptionNomeInteressado;
    private WebElement abaProcessos;
    private WebElement botaoBusca;

    public ConsultaDocumentosPageObject(WebDriver driver) {
        this.driver = driver;

        this.radioOptionNomeInteressado = driver.findElement(By.xpath("//*[@id=\"documentosForm\"]/div[2]/input[1]"));
        this.abaProcessos = driver.findElement(By.id("l-buscadocumentos"));
        this.botaoBusca = driver.findElement(By.xpath("//*[@id=\"documentosForm\"]/input[3]"));

    }

    public void buscar() {
        botaoBusca.click();
    }

    public void selecionarCampoNomeInteressado() {
        radioOptionNomeInteressado.click();
    }

    public void acessarAbaDocumentos() {
        abaProcessos.click();
    }

}
