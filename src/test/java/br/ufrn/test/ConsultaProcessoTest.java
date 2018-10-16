package br.ufrn.test;

import br.ufrn.test.base.AbstractTest;
import br.ufrn.test.base.Constants;
import br.ufrn.test.pageobject.ConsultaProcessosPageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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

}
