package com.alura.appium.PageObject;

import com.alura.appium.AppiumDriverConfig;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.SpringVersion;

public class CadastroPageObject extends PageObjectBase{

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement mensagemErro;

    private final By erroID;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By campoConfirmacaoID;
    private final By botaoCadastrarID;

    public CadastroPageObject(AppiumDriverConfig driver){
        super(driver);
        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmacaoID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

    }

    @Override
    public void BuscarElementos(){

        campoNome = (MobileElement) driver.driver.findElement(campoNomeID);
        campoSenha = (MobileElement) driver.driver.findElement(campoSenhaID);
        campoConfirmarSenha = (MobileElement) driver.driver.findElement(campoConfirmacaoID);
        botaoCadastrar = (MobileElement) driver.driver.findElement(botaoCadastrarID);



    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao){

        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);

    }

    public LoginPageObject Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPageObject(driver);
    }


    public String MensagemErro() {
        WebDriverWait espera = new WebDriverWait(driver.driver, 5);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroID));

        mensagemErro = (MobileElement) driver.driver.findElement(erroID);
        return  mensagemErro.getText();
    }
}