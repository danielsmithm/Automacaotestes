package br.ufrn.test;

import br.ufrn.test.base.AbstractTest;
import br.ufrn.test.base.Constants;
import br.ufrn.test.pageobject.ConsultaProcessosPageObject.Campo;
import br.ufrn.test.pageobject.ConsultaProcessosPageObject;
import br.ufrn.test.pageobject.ResultadoDocumentosPageObject;
import br.ufrn.test.pageobject.ResultadoProcessosPageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.TimeoutException;

import static br.ufrn.test.pageobject.PageObjectLoader.loadPageObject;

@RunWith(JUnit4.class)
public class ConsultaProcessoTest extends AbstractTest {

    @Test
    public void testConsultarProcessos_porNomeInteressado_semInformarInteressado(){
        driver.get(Constants.baseURL);
        ConsultaProcessosPageObject pageObject = loadPageObject(driver,ConsultaProcessosPageObject.class);

        pageObject.acessarAbaProcessos();
        pageObject.selecionarCampoNomeInteressado();
        pageObject.buscar();
    }
    
    @Test
	public void testHappyPathComInteressado()
	{
		ResultadoProcessosPageObject resultado = requisicao(Constants.will);
    	assertTrue(resultado.getForm());
	}

	@Test
	public void testHappyPathComMatricula()
	{
		ResultadoProcessosPageObject resultado = requisicao(Constants.matricula, Campo.Matricula);
    	assertTrue(resultado.getForm());
	}
	
	@Test (expected = TimeoutException.class)
	public void testExcedendoLimiteDeNumeros()
	{
		ResultadoProcessosPageObject resultado = requisicao(Constants.longMatricula, Campo.Matricula);
    	assertTrue(resultado.getForm());
	}
	
	@Test (expected = TimeoutException.class)
	public void testCPFIncompleto()
	{
		ResultadoProcessosPageObject resultado = requisicao("14", Campo.Matricula);
    	assertTrue(resultado.getForm());
	}
	
	@Test (expected = TimeoutException.class)
	public void testExcedendoLimiteDeChar()
	{
		ResultadoProcessosPageObject resultado = requisicao(Constants.longString);
    	assertTrue(resultado.getForm());
	}
	
    @Test
    public void testConsultarDocumento_semInformarInteressado(){
        requisicao(Constants.empty);
    }
    
    @Test (expected = TimeoutException.class)
    public void testJsInjection()
    {
    	ResultadoProcessosPageObject resultado = requisicao(Constants.htmlInjection);
    	assertEquals(null, resultado.getForm());
    }
    
    @Test (expected = TimeoutException.class)
    public void testSqlInjection()
    {
    	ResultadoProcessosPageObject resultado = requisicao(Constants.sqlInjection);
    	assertEquals(null, resultado.getForm());
    }

    private ResultadoProcessosPageObject requisicao(String content)
    {
    	return requisicao(content, Campo.Interessado);
    }
    
    private ResultadoProcessosPageObject requisicao(String content, Campo escolha)
    {
    	driver.get(Constants.baseURL);
        ConsultaProcessosPageObject pageObject = loadPageObject(driver,ConsultaProcessosPageObject.class);

        pageObject.acessarAbaProcessos();
        pageObject.selecionarCampo(escolha);
        pageObject.preencherNomeInteressado(content);
        pageObject.buscar();
        
        return loadPageObject(driver, ResultadoProcessosPageObject.class);
    }
	
}
