package com.alura.appium;

import com.alura.appium.PageObject.CadastroPageObject;
import com.alura.appium.PageObject.LoginPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;


public class FeatureCadastro {

    @Test
    public void deve_cadastrar_usuario_com_senhas_que_conferem() throws MalformedURLException, NoSuchElementException {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar("Bugan", "123", "123");
        telaLogin.BuscarElementos();

//         Não necessariamente precisa do assert, com o NoSuchElementException se consegue
//         saber se a transição de tela foi bem sucedida
//        Assert.assertEquals("LOGAR", botaoLogar.getText());
    }

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() throws MalformedURLException {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Bugan", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
    }
}
