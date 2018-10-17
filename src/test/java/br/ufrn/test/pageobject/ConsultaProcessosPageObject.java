package br.ufrn.test.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.ufrn.test.pageobject.ConsultaDocumentosPageObject.Campo;

public class ConsultaProcessosPageObject extends AbstractPageObject{

    @FindBy(how = How.XPATH, using = "//*[@id=\"processoForm\"]/div[2]/input[1]")
    private WebElement radioOptionNomeInteressado;

    @FindBy(how = How.ID, using = "l-processos")
    private WebElement abaProcessos;

    @FindBy(how = How.XPATH, using = "//*[@id=\"processoForm\"]/input[3]")
    private WebElement botaoBusca;

    @FindBy(how = How.XPATH, using = "//*[@id=\"processoForm\"]/div[2]/input[2]")
    private WebElement nomeInteressado;

    @FindBy(how = How.XPATH, using = "//*[@id=\"processoForm\"]/div[3]/input[2]")
    private WebElement campoCpf;

    @FindBy(how = How.XPATH, using = "//*[@id=\"processoForm\"]/div[3]/input[1]")
    private WebElement radioOptionCpf;

    public void selecionarCampo(Campo escolha)
    {
    	switch (escolha)
    	{
    		case Interessado:
    			selecionarCampoNomeInteressado();
    		break;
    		
    		case Matricula:
    			selecionarCampoCpf();
    		break;
    	}
    }
    public void buscar() {
        botaoBusca.click();
    }

    public void selecionarCampoNomeInteressado() {
        radioOptionNomeInteressado.click();
    }

    public void selecionarCampoCpf(){
        radioOptionCpf.click();
    }

    public void preencherCpf(String valor){
        campoCpf.sendKeys(valor);
    }

    public void preencherNomeInteressado(String valor){
        nomeInteressado.sendKeys(valor);
    }

    public void acessarAbaProcessos() {
        abaProcessos.click();
        waitFor(ExpectedConditions.visibilityOfAllElements(radioOptionNomeInteressado));
    }

    public enum Campo
    {
    	Interessado,
    	Matricula
    }
}
