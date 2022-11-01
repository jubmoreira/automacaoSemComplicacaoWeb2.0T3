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
        String titulo = getTitulo   ();
        assertEquals("Porque Tempo É Conhecimento", titulo);

    }

    private String getTitulo() {
        String xpathTitulo = "//section[2]//h4";

        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        return titulo;
    }

    @Test
    public void segundoTeste(){
        clickBotao();

        String xpathTitulo = "div.text-center > div.large-h1";
        WebElement h2Titulo = driver.findElement(By.xpath(xpathTitulo));
        assertEquals("Conheça todos os nossos cursos",h2Titulo.getText() );
    }

    private void clickBotao() {
        String xpathBotao = "//section[2]/div[3]//gita";
        WebElement btnTitulo = driver.findElement(By.xpath(xpathBotao));
        btnTitulo.click();
    }

}
