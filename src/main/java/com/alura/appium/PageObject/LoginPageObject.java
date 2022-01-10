package com.alura.appium.PageObject;

import com.alura.appium.AppiumDriverConfig;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class LoginPageObject extends PageObjectBase{


    private MobileElement botaoCadastro;
    private final By botaoCadastrarID;

    public LoginPageObject(AppiumDriverConfig driver){
        super(driver);
        botaoCadastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

    }
    @Override
    public void BuscarElementos() {
        botaoCadastro = (MobileElement) driver.driver.findElement(botaoCadastrarID);

    }

    public CadastroPageObject IrParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }
}
