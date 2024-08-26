package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Pedido {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";

    private String requestBody;

    @Step("Preparar la orden con id {0}, petId {1}, y quantity {2}")
    public void prepararPedido(String id, String petId, String quantity) {
        requestBody = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"petId\": " + petId + ",\n" +
                "  \"quantity\": " + quantity + ",\n" +
                "  \"shipDate\": \"2024-08-25T23:41:55.481Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
    }

    @Step("Crear la orden de compra")
    public void crearPedido() {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body(requestBody)
                .post(BASE_URL);
    }

    @Step("Validar código de respuesta {0}")
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Step("Validar campo {0} con valor {1}")
    public void validarCampo(String campo, String valorEsperado) {
        if (esNumerico(valorEsperado)) {
            restAssuredThat(response -> response.body(campo, equalTo(Integer.parseInt(valorEsperado))));
        } else {
            restAssuredThat(response -> response.body(campo, equalTo(valorEsperado)));
        }
    }

    private boolean esNumerico(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean consultarOrden(String id) {
        boolean existeID = false;
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(BASE_URL+"/"+ id)
                .then()
                .log().all();
        if (lastResponse().statusCode()==200){ existeID = true; }
        return existeID;
    }





}
