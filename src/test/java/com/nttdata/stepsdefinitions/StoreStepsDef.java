package com.nttdata.stepsdefinitions;

import com.nttdata.page.StorePage;
import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class StoreStepsDef {

    // Instancia al selenium webdriver
    private WebDriver driver;
    private StoreSteps storeSteps;

    @Dado("estoy en la página de la tienda")
    public void estoy_en_la_página_de_la_tienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        storeSteps = new StoreSteps(driver);
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String user, String password) {
        storeSteps.login(user, password);
        screenShot();

    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String category, String subCategory) {
        storeSteps.navigateToCategory(category, subCategory);
    }

    @Cuando("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int quantity) {
        storeSteps.addFirstProductToCart(quantity);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        Assertions.assertTrue(driver.findElement(StorePage.cartPopup).isDisplayed(), "El popup de confirmación no es visible.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.cartPopup));
    }

    @Entonces("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        String popupTotal = driver.findElement(StorePage.cartPopupTotal).getText();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.cartPopup));
    }

    @Cuando("finalizo la compra")
    public void finalizo_la_compra() {
        storeSteps.checkout();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        storeSteps.validateCartPageTitle("CARRITO");
    }

    @Entonces("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        storeSteps.validateCartTotal();
        screenShot();
    }

}
