package br.ufrn.test;

import br.ufrn.test.base.AbstractTest;
import br.ufrn.test.base.Constants;
import br.ufrn.test.pageobject.ConsultaUnidadePageObject;
import br.ufrn.test.pageobject.ResultadoUnidadePageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.TimeoutException;

import static br.ufrn.test.pageobject.PageObjectLoader.loadPageObject;

@RunWith(JUnit4.class)
public class ConsultaUnidadeTest extends AbstractTest {

	//@Test
	public void testHappyPath()
	{
		//melhorar a validação, por exemplo verificar se todos os itens da lista são do imd realmente
		ResultadoUnidadePageObject resultado = requisicao(Constants.imd);
    	assertTrue(resultado.getForm());
	}
	
    //@Test
    public void testConsultaUnidade_semInformarNome(){
    	ResultadoUnidadePageObject resultado = requisicao(Constants.empty);
    	assertTrue(resultado.getForm());
    }
    
    //@Test (expected=TimeoutException.class)
    public void testStringLonga()
    {
    	ResultadoUnidadePageObject resultado = requisicao(Constants.longString);
    	assertEquals(null, resultado.getForm());
    }
    
    //@Test (expected=TimeoutException.class)
    public void testMetodoDeCodificacao()
    {
    	ResultadoUnidadePageObject resultado = requisicao(Constants.hindiString);
    	assertEquals(null, resultado.getForm());
    }
    
    //@Test (expected=TimeoutException.class)
    public void testJsInjection()
    {
    	ResultadoUnidadePageObject resultado = requisicao(Constants.jsInjection);
    	assertEquals(null, resultado.getForm());
    }
    
    @Test (expected=TimeoutException.class)
    public void testSqlInjection()
    {
    	//nao retorna nada mas a url fica assim https://sipac.ufrn.br/public/jsp/portal.jsf;jsessionid=055DD2CC241F0AD6765B9662B6EC7635.sipac02-producao
    	ResultadoUnidadePageObject resultado = requisicao(Constants.sqlInjection);
    	assertEquals(null, resultado.getForm());
    }
    
    private ResultadoUnidadePageObject requisicao(String content)
    {
    	driver.get(Constants.baseURL);
        ConsultaUnidadePageObject pageObject = loadPageObject(driver,ConsultaUnidadePageObject.class);

        pageObject.selecionaAbaUnidade();
        pageObject.preencherNome(content);
        pageObject.buscar();
                
        return loadPageObject(driver, ResultadoUnidadePageObject.class);
    }
}
