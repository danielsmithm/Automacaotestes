package br.ufrn.test.br.ufrn.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory {

    public static WebDriver createWebDriver(){
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        return new ChromeDriver();
    }

}
