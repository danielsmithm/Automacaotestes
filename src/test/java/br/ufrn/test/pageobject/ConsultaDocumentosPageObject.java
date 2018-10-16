package br.ufrn.test.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ConsultaDocumentosPageObject extends AbstractPageObject{

    @FindBy(how = How.XPATH, using = "//*[@id=\"documentosForm\"]/div[2]/input[1]")
    private WebElement radioOptionNomeInteressado;

    @FindBy(how = How.ID, using = "l-buscadocumentos")
    private WebElement abaProcessos;

    @FindBy(how = How.XPATH, using = "//*[@id=\"documentosForm\"]/input[3]")
    private WebElement botaoBusca;

    @FindBy(how = How.XPATH, using = "//*[@id=\"documentosForm\"]/div[2]/input[2]")
    private WebElement nomeInteressado;

    @FindBy(how = How.XPATH, using = "//*[@id=\"documentosForm\"]/div[3]/input[2]")
    private WebElement campoCpf;

    @FindBy(how = How.XPATH, using = "//*[@id=\"documentosForm\"]/div[3]/input[1]")
    private WebElement radioOptionCpf;

    public void buscar() {
        botaoBusca.click();
    }

    public void selecionarCampoCpf(){
        radioOptionCpf.click();
    }

    public void preencherCpf(String valor){
        campoCpf.sendKeys(valor);
    }

    public void selecionarCampoNomeInteressado() {
        radioOptionNomeInteressado.click();
    }

    public void preencherNomeInteressado(String valor){
        nomeInteressado.sendKeys(valor);
    }

    public void acessarAbaDocumentos() {
        abaProcessos.click();
        waitFor(ExpectedConditions.visibilityOfAllElements(radioOptionNomeInteressado));
    }

}
