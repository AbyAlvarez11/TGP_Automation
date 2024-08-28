package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


    public class HomeScreen extends PageObject {

        @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup")
        private WebElement home;

        public boolean isHomePageDisplayed() {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOf(home));
                // Opcionalmente, podrías agregar una condición adicional para asegurarte de que el contenido sea correcto.

                // Verifica si el elemento home está efectivamente visible y devuelve true
                return home.isDisplayed();
            } catch (TimeoutException e) {
                // Si el elemento no está visible dentro del tiempo de espera, captura la excepción y devuelve false
                return false;
            }
        }


    }

