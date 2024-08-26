package com.nttdata.stepsDefs;

import com.nttdata.steps.Pedido;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class UsuarioStepsDefs {

    @Steps
    Pedido pedido;

    @Given("detalle del pedido con id {}, petId {}, y quantity {}")
    public void detalleDelPedidoConIdPetIdYQuantity(String id, String petId, String quantity) {
        pedido.prepararPedido(id, petId, quantity);
    }

    @When("creo la orden de compra")
    public void crearPedido() {
        pedido.crearPedido();
    }

    @Then("el código de respuesta es {int}")
    public void validarCodigoDeRespuesta(int statusCode) {
        pedido.validarCodigoRespuesta(statusCode);
    }

    @And("el id de la orden es {string}")
    public void validarIdPedido(String id) {
        pedido.validarCampo("id", id);
    }

    @And("el petId de la orden es {string}")
    public void validarPetIdPedido(String petId) {
        pedido.validarCampo("petId", petId);
    }

    @And("la cantidad de la orden es {string}")
    public void validarCantidadPedido(String quantity) {
        pedido.validarCampo("quantity", quantity);
    }

    @And("el estado de la orden es {string}")
    public void validarEstadoPedido(String status) {
        pedido.validarCampo("status", status);
    }

    @When("envío una solicitud GET para consultar la orden con ID {string}")
    public void envioUnaSolicitudGETParaConsultarPedidoConID(String id) {
        Assert.assertTrue("No existe pedido",pedido.consultarOrden(id));
    }


}
