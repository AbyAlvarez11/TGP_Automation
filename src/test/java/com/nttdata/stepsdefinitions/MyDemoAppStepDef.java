package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyDemoAppCartSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
//import static com.nttdata.core.DriverManager.screenShot;

public class MyDemoAppStepDef {
    @Steps
    MyDemoAppCartSteps cartSteps;


    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        cartSteps.validarCargaDeAplicacion();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        cartSteps.validarProductosCargados();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoProductoAlCarrito(int unidades, String producto) {
        cartSteps.agregarProductoAlCarrito(producto, unidades);

    }

    //cartSteps.agregarProductoAlCarrito(producto, unidades);

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        // click en addToCart
        // click en el carrito de compras
        // valido el nombre del procducto y la cantidad


    }


    //cartSteps.validarActualizacionCarrito();

}
