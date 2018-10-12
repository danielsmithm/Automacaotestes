package br.ufrn.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnit4.class)
public class ExampleTest {

    private WebDriver driver;

    @Before
    public void setup(){
        //System.setProperty("webdriver.chrome.driver", "Caminho para o chrome driver");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void exampleTest(){
        driver.get("https://google.com");
    }

}
