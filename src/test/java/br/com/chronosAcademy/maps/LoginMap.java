package br.com.chronosAcademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUserLink")
    public WebElement btnLogin;
    public WebElement bthFechar;
    public WebElement divFechaModal;
    public WebElement inpUserName;
    public WebElement inpPassword;
    public WebElement inpRemember;
    public WebElement btnSingIn;
    public WebElement linkCreateAccount;

}
