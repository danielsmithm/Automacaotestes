package br.ufrn.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectLoader {

    public static <T extends AbstractPageObject> T loadPageObject(WebDriver driver, Class<T> clazz){

        T pageObject = PageFactory.initElements(driver,clazz);

        if(pageObject == null){
            throw new IllegalStateException("Erro ao instanciar o page object. Era esperada uma instância do page object.");
        }

        pageObject.setDriver(driver);

        return pageObject;
    }

}
