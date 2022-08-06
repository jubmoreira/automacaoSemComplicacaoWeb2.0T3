package br.com.chronosAcademy.automacaoWeb;

import br.com.chronosAcademy.core.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class TesteWeb {
    WebDriver driver;
    Driver driverWeb;

    @Before
    public void inicializaTeste(){
        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
    }
    @After
    public void finalizaTeste(){
        driver.quit();
    }

    @Test
    public void primeiroTeste(){
        //section[2]/div[3]/div/div/div/div/div[1]/div/h4 -poderia ser usada sem problemas
        String xpathTitulo = "//section[2]//h4";

        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        assertEquals("Porque Tempo É Conhecimento", titulo);

    }

    @Test
    public void segundoTeste(){
        String xpathBotao = "//section[2]/div[3]//a";
        WebElement btnTitulo = driver.findElement(By.xpath(xpathBotao));
        btnTitulo.click();

        String xpathTitulo = "//section/div/div/div/div[2]/div/div[3]//h3";
        WebElement h2Titulo = driver.findElement(By.xpath(xpathTitulo));
        assertEquals("Automação Sem Complicação Web 2.0",h2Titulo.getText() );
    }

}
