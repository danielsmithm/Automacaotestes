package br.ufrn.test;

import br.ufrn.test.pageobject.ConsultaDocumentosPageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConsultaDocumentosTest extends AbstractTest {

    @Test
    public void testConsultarDocumento_semInformarInteressado(){
        driver.get("https://sipac.ufrn.br/public/jsp/portal.jsf");
        ConsultaDocumentosPageObject pageObject = new ConsultaDocumentosPageObject(driver);

        pageObject.acessarAbaDocumentos();
        pageObject.selecionarCampoNomeInteressado();
        pageObject.buscar();

    }

}
