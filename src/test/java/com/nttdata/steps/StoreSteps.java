package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.nttdata.core.DriverManager.screenShot;


public class StoreSteps {

    private WebDriver driver;


    public StoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(StorePage.loginButtonF).click();
        screenShot();
        driver.findElement(StorePage.userInput).sendKeys(user);
        driver.findElement(StorePage.passwordInput).sendKeys(password);
        screenShot();
        driver.findElement(StorePage.loginButton).click();

        // Esperar hasta que el mensaje de error sea visible o invisible
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message"))); // Ajusta el selector según tu HTML
            String actualErrorMessage = errorMessage.getText();
            Assertions.assertEquals("Error de autenticación.", actualErrorMessage, "El mensaje de error no coincide");
            // Si llega aquí, el login falló
            System.out.println("Login fallido");
            Assert.fail("Login fallido: " + actualErrorMessage); // Detener la prueba con un error
        } catch (TimeoutException e) {
            // Si no se encuentra el mensaje de error, asumimos que el login fue exitoso
            System.out.println("Login exitoso");
            // Continuar con el resto de la prueba
        }

//        String alertDangerText = driver.findElement(StorePage.alertDanger).getText();
//        Assertions.assertEquals("Error de autenticación.", alertDangerText, "Credenciales incorrectas.");
    }

    public void navigateToCategory(String category, String subCategory) {
        String categoryClothesText = driver.findElement(StorePage.categoryClothes).getText();
        Assertions.assertEquals(categoryClothesText, category, "No se encontro categoria.");
        driver.findElement(StorePage.categoryClothes).click();
        screenShot();

        String subCategoryMenText = driver.findElement(StorePage.subCategoryMen).getText();
        Assertions.assertEquals(subCategoryMenText, subCategory, "No se encontro subcategoria.");
        driver.findElement(StorePage.subCategoryMen).click();
        screenShot();

    }

    public void addFirstProductToCart(int quantity) {
        driver.findElement(StorePage.firstProductMen).click();
        screenShot();

        for (int i = 0; i < quantity-1; i++) {
            driver.findElement(StorePage.touchSpinUp).click();
            screenShot();
        }
        driver.findElement(StorePage.addButton).click();
        screenShot();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.cartPopup));
    }

    public void checkout() {
        driver.findElement(StorePage.checkoutButton).click();
    }

    public void validateCartPageTitle(String expectedTitle) {
        String actualTitle = driver.findElement(StorePage.cartPageTitle).getText();
        Assertions.assertEquals(expectedTitle, actualTitle, "El título de la página del carrito es incorrecto.");
    }

    public void validateCartTotal() {
        String cartTotalProductText = driver.findElement(StorePage.cartTotalProduct).getText();
        String cartTotalText = driver.findElement(StorePage.cartTotal).getText();
        Assertions.assertEquals(cartTotalProductText, cartTotalText, "El total en el carrito es incorrecto.");
    }


}
