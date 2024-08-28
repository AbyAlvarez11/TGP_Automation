package com.nttdata.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyDemoAppCartScreen extends PageObject {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")
    private WebElement pantallaInicial;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup")
    private List<WebElement> productos;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]")
    private WebElement producto;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement itemCarrito;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement itemsCarrito;


    public boolean estanProductosCargados() {
        AndroidDriver<MobileElement> driver = null;
        
        try {
            // Obtener todas las imágenes de los productos visibles
            List<MobileElement> productImages = driver.findElements(By.xpath("//android.widget.ImageView[contains(@content-desc, 'Sauce Labs')]"));

            // Verificar que al menos una imagen de producto esté visible
            for (WebElement productImage : productImages) {
                if (!productImage.isDisplayed()) {
                    System.out.println("Una imagen de producto no se muestra.");
                    return false;
                }
            }

            // Obtener todos los nombres de los productos visibles
            List<MobileElement> productNames = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV']"));

            // Verificar que al menos un nombre de producto esté visible
            for (WebElement productName : productNames) {
                if (!productName.isDisplayed()) {
                    System.out.println("Un nombre de producto no se muestra.");
                    return false;
                }
            }

            // Si todos los productos se han validado correctamente
            return true;

        } catch (NoSuchElementException e) {
            // Si no se encuentra un elemento, devolver false
            System.out.println("Un elemento no se pudo encontrar: " + e.getMessage());
            return false;
        }
    }

    public void seleccionarProducto(String producto) {
//        String contentDesc = producto.getAttribute("content-desc");
//        if (contentDesc != null && contentDesc.equals(producto)) {
//            // Realiza la acción necesaria si hay coincidencia
//            producto.click();
//        } else {
//            // Manejo de error o lógica si no coincide
//            System.out.println("Producto no encontrado o no coincide con el parámetro proporcionado.");
//        }
    }

    public void seleccionarCantidad(int unidades) {
    }


    public boolean carritoActualizado() {
    // Validar si el número de items en el carrito se actualiza correctamente
    return itemsCarrito.isDisplayed();
    }

    public boolean pantallaInicialVisible() {
        pantallaInicial.getLocation();
        return false;
    }


}
