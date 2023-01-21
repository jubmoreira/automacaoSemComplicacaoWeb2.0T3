package br.com.chronosAcademy.pages;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    LoginMap loginMap;

    public LoginPage(){
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }

    public void clickBtnLogin(){
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }
    public void clickBtnFechar(){
        loginMap.bthFechar.click();
    }
    public void clickDivFecharModal(){
        loginMap.divFechaModal.click();
    }
    public void setInpUserName(String username){
        loginMap.inpUserName.sendKeys(username);
    }
    public void setInpPassword(String password){
        loginMap.inpPassword.sendKeys(password);
    }
    public void clickInpRemember(){
        loginMap.inpRemember.click();
    }
    public void clickCreateAccount(){
        loginMap.linkCreateAccount.click();
    }
    public void clickBtnSingIn(){
        loginMap.btnSingIn.click();
    }
    public boolean isBtnSingIn(){
        return loginMap.btnSingIn.isEnabled();
    }

    public void visibilityOfBtnFechar(){
        Driver.visibilityOf(loginMap.bthFechar);
    }
    public void invisibiityOfBtnFechar(){
        Driver.invisibilityOf(loginMap.bthFechar);
    }



}
