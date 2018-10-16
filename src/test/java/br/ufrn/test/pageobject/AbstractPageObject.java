package br.ufrn.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPageObject {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitFor(ExpectedCondition<List<WebElement>> condition) {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(condition);
    }
}
