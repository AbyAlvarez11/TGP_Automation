package com.nttdata.page;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;


public class StorePage {

    //Localizadores de elementos
    public static By loginButtonF = By.xpath("//*[@id=\"_desktop_user_info\"]/div");
    public static By userInput = By.xpath("//*[@id=\"field-email\"]");
    public static By passwordInput = By.xpath("//*[@id=\"field-password\"]");
    public static By loginButton = By.xpath("//*[@id=\"submit-login\"]");
    public static By loginPage = By.xpath("//*[@id=\"wrapper\"]");
    public static By alertDanger = By.xpath("//*[@id=\"content\"]/section/div/ul/li");

    public static By categoryClothes = By.xpath("//*[@id=\"category-3\"]/a");
    public static By subCategoryMen = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");

    public static By firstProductMen = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div");
    public static By currentprice = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]"); //precio
    public static By touchSpinUp = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i");
    public static By quantity = By.xpath("//*[@id=\"quantity_wanted\"]"); // cantidad escogida
    public static By addButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"); // boton aniadir carrito
    public static By cartPopup = By.xpath("//*[@id=\"blockcart-modal\"]/div/div");
    public static By quantityProduct = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong"); // cantidad a comparar
    public static By cartPopupTotal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By checkoutButton = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"); //boton finalizar compra
    public static By cartPageTitle = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
    public static By cartTotalProduct = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");
    public static By cartTotal = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");

}
