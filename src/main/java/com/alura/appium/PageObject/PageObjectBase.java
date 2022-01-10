package com.alura.appium.PageObject;

import com.alura.appium.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;

public abstract class PageObjectBase {

    protected final AppiumDriverConfig driver;

    protected PageObjectBase (AppiumDriverConfig driver){
        this.driver = driver;

    }
    public abstract void BuscarElementos();

}
