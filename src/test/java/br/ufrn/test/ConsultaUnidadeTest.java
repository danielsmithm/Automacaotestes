package br.ufrn.test;

import br.ufrn.test.base.AbstractTest;
import br.ufrn.test.pageobject.ConsultaUnidadePageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static br.ufrn.test.pageobject.PageObjectLoader.loadPageObject;

@RunWith(JUnit4.class)
public class ConsultaUnidadeTest extends AbstractTest {

    @Test
    public void testConsultaUnidade_semInformarNome(){
        driver.get("https://sipac.ufrn.br/public/jsp/portal.jsf");
        ConsultaUnidadePageObject pageObject = loadPageObject(driver,ConsultaUnidadePageObject.class);

        pageObject.selecionaAbaUnidade();
        pageObject.preencherNome("potato");
        pageObject.buscar();
    }
}
