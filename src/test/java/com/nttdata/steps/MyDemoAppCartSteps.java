package com.nttdata.steps;

import com.nttdata.screens.HomeScreen;
import com.nttdata.screens.MyDemoAppCartScreen;
import org.junit.Assert;

public class MyDemoAppCartSteps {
    MyDemoAppCartScreen cartScreen;
    HomeScreen homeScreen;


    public void validarCargaDeAplicacion() {
        Assert.assertTrue(homeScreen.isHomePageDisplayed());
    }

    public void validarProductosCargados() {
        Assert.assertTrue(cartScreen.estanProductosCargados());
    }

    public void agregarProductoAlCarrito(String producto, int unidades) {
        // click en el articulo con el nombre ""
        cartScreen.seleccionarProducto(producto);
        // click la cantidad de veces que indique el example
        cartScreen.seleccionarCantidad(unidades);
    }

    public void validarActualizacionCarrito() {
        Assert.assertTrue(cartScreen.carritoActualizado());
    }


}
