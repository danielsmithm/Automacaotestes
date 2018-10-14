package br.ufrn.test;

import br.ufrn.test.pageobject.ConsultaUnidadePageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConsultaUnidadeTest extends AbstractTest {

    @Test
    public void testConsultaUnidade_semInformarNome(){
        driver.get("https://sipac.ufrn.br/public/jsp/portal.jsf");
        ConsultaUnidadePageObject pageObject = new ConsultaUnidadePageObject(driver);

        pageObject.selecionaAbaUnidade();
        pageObject.preencherNome("batata");
        pageObject.buscar();
    }
}
