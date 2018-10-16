package br.ufrn.test.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConsultaUnidadePageObject extends AbstractPageObject{

    @FindBy(how = How.ID, using = "l-unidades")
    private WebElement abaUnidade;

    @FindBy(how = How.XPATH, using = "//*[@id=\"unidade\"]/div[2]/input")
    private WebElement botaoBusca;

    @FindBy(how = How.XPATH, using = "unidade:nome")
    private WebElement campoNome;

    public void selecionaAbaUnidade() {
        abaUnidade.click();
    }

    public void preencherNome(String nome) {
        campoNome.sendKeys(nome);
    }

    public void buscar() {
        botaoBusca.click();
        waitFor(ExpectedConditions.visibilityOfAllElements(campoNome));
    }

}


