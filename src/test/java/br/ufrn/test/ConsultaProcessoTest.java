package br.ufrn.test;

import br.ufrn.test.pageobject.processos.ConsultaProcessosPageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConsultaProcessoTest extends AbstractTest {

    @Test
    public void testConsultarProcessos_porNomeInteressado_semInformarInteressado() throws Exception {
        driver.get("https://sipac.ufrn.br/public/jsp/portal.jsf");
        ConsultaProcessosPageObject pageObject = new ConsultaProcessosPageObject(driver);

        pageObject.acessarAbaProcessos();
        pageObject.selecionarCampoNomeInteressado();
        pageObject.buscar();
    }

}
