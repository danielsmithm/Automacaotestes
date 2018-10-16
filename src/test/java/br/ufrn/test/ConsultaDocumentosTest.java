package br.ufrn.test;

import br.ufrn.test.base.AbstractTest;
import br.ufrn.test.base.Constants;
import br.ufrn.test.pageobject.ConsultaDocumentosPageObject;
import br.ufrn.test.pageobject.ConsultaDocumentosPageObject.Campo;
import br.ufrn.test.pageobject.ResultadoDocumentosPageObject;
import br.ufrn.test.pageobject.ResultadoUnidadePageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.TimeoutException;

import static br.ufrn.test.pageobject.PageObjectLoader.loadPageObject;

@RunWith(JUnit4.class)
public class ConsultaDocumentosTest extends AbstractTest 
{
	@Test
	public void testHappyPathComInteressado()
	{
		ResultadoDocumentosPageObject resultado = requisicao(Constants.will);
    	assertTrue(resultado.getForm());
	}
	
	@Test
	public void testHappyPathComMatricula()
	{
		ResultadoDocumentosPageObject resultado = requisicao(Constants.matricula, Campo.Matricula);
    	assertTrue(resultado.getForm());
	}
	
	@Test (expected = TimeoutException.class)
	public void testExcedendoLimiteDeNumeros()
	{
		ResultadoDocumentosPageObject resultado = requisicao(Constants.longMatricula, Campo.Matricula);
    	assertTrue(resultado.getForm());
	}
	
	@Test (expected = TimeoutException.class)
	public void testExcedendoLimiteDeChar()
	{
		ResultadoDocumentosPageObject resultado = requisicao(Constants.longString);
    	assertTrue(resultado.getForm());
	}
	
    @Test
    public void testConsultarDocumento_semInformarInteressado(){
        requisicao(Constants.empty);
    }
    
    @Test (expected = TimeoutException.class)
    public void testJsInjection()
    {
    	ResultadoDocumentosPageObject resultado = requisicao(Constants.htmlInjection);
    	assertEquals(null, resultado.getForm());
    }
    
    @Test (expected = TimeoutException.class)
    public void testSqlInjection()
    {
    	ResultadoDocumentosPageObject resultado = requisicao(Constants.sqlInjection);
    	assertEquals(null, resultado.getForm());
    }

    private ResultadoDocumentosPageObject requisicao(String content)
    {
    	return requisicao(content, Campo.Interessado);
    }
    
    private ResultadoDocumentosPageObject requisicao(String content, Campo escolha)
    {
    	driver.get(Constants.baseURL);
        ConsultaDocumentosPageObject pageObject = loadPageObject(driver,ConsultaDocumentosPageObject.class);

        pageObject.acessarAbaDocumentos();
        pageObject.selecionarCampo(escolha);
        pageObject.preencherNomeInteressado(content);
        pageObject.buscar();
        
        return loadPageObject(driver, ResultadoDocumentosPageObject.class);
    }
    
}
