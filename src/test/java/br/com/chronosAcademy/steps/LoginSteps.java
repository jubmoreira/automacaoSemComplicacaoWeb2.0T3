package br.com.chronosAcademy.steps;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.enums.Browser;
import br.com.chronosAcademy.pages.LoginPage;
import br.com.chronosAcademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;


public class LoginSteps {
    LoginPage loginPage;

    @Before
    public void iniciaNavegador(){
        new Driver(Browser.CHROME);
    }

    @After
    public void fechaNavegador(){
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://www.advantageonlineshopping.com/");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();
    }
    @Quando("for realizado um clique fora da modal")
    public void forRealizadoUmCliqueForaDaModal() {
        loginPage.clickDivFecharModal();
    }

    @Entao("a janela modal sera fechada")
    public void aJanelaModalSeraFechada() throws Exception {
        try {
            loginPage.invisibiityOfBtnFechar();
        }catch (Exception e){
            throw new Exception("A janela modal não foi fechada");
        }
    }

    @Quando("for realizado um clique no icone de fechar a modal")
    public void forRealizadoUmCliqueNoIconeDeFecharAModal() {
        loginPage.clickBtnFechar();
    }

    @Quando("for realizado um clique no link Create New Account")
    public void forRealizadoUmCliqueNoLinkCreateNewAccount() {
        loginPage.clickCreateAccount();
    }

    @Entao("a pagina Create Account sera exibida")
    public void aPaginaCreateAccountSeraExibida() {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT",newAccountPage.getTextNewAccount());
    }

    @Quando("os campos de login forem preenchidos da seguinte forma")
    public void osCamposDeLoginForemPreenchidosDaSeguinteForma(Map<String, String> map) {
        String username = map.get("usuario");
        String password = map.get("senha");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        if(username != null){
            loginPage.setInpUserName(username);
        }

        if (password != null){
            loginPage.setInpPassword(password);
        }
        if(remember) loginPage.clickInpRemember();
    }

    @Quando("for realizado um clique no botao sign in")
    public void forRealizadoUmCliqueNoBotaoSignIn() {
        loginPage.clickBtnSingIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() {
        
    }

    @Entao("o sistema deve exibir uma mensagem de erro")
    public void oSistemaDeveExibirUmaMensagemDeErro() {
        
    }

    @Então("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSingIn();
        Assert.assertFalse(enabled);
    }
}
