package br.ufrn.test;

import br.ufrn.test.base.AbstractTest;
import br.ufrn.test.base.Constants;
import br.ufrn.test.pageobject.ConsultaDocumentosPageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.support.PageFactory;

import static br.ufrn.test.pageobject.PageObjectLoader.loadPageObject;

@RunWith(JUnit4.class)
public class ConsultaDocumentosTest extends AbstractTest {

    @Test
    public void testConsultarDocumento_semInformarInteressado(){
        driver.get(Constants.baseURL);
        ConsultaDocumentosPageObject pageObject = loadPageObject(driver,ConsultaDocumentosPageObject.class);

        pageObject.acessarAbaDocumentos();
        pageObject.selecionarCampoNomeInteressado();
        pageObject.preencherNomeInteressado("");
        pageObject.buscar();

    }

}
