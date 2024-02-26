package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.*;
import org.openqa.selenium.*;

public class CartPage extends BasePage {

    private static final String PAGE_LOCATOR = "//span[@class='title' and text()='Your Cart']";

    private static final TextBox ITEM_NAME_IN_THE_CART = new TextBox(By.xpath("//div[@class='inventory_item_name']"));

    private static final TextBox ITEM_PRICE_IN_CART = new TextBox(By.xpath("//div[@class='inventory_item_price']"));

    private static final Button CHECKOUT_BUTTON = new Button(By.xpath("//button[@name='checkout']"));

    public static String itemNameInCart;

    public static double priceInCart;

    public CartPage() {
        super(By.xpath(PAGE_LOCATOR), "'Cart' Page");
        priceInCart = Double.parseDouble(ITEM_PRICE_IN_CART.getText().replace("$", ""));
        itemNameInCart = ITEM_NAME_IN_THE_CART.getText();
    }

    public void itemNameInCartValidation() {
        System.out.println("Item selected: " + ProductsPage.productName + " vs Item in Card: " +
                SingleProductPage.singleProductName + " vs Item in cart: " + itemNameInCart);
        if (SingleProductPage.singleProductName.equals(itemNameInCart)) {
            System.out.println("Names are match");
        } else {
            System.out.println("Not Match");
        }
    }

    public void itemPriceValidation() {
        System.out.println("Selected item Price: " + ProductsPage.getProductPrice() + " vs Price in Card: " +
                SingleProductPage.singleProductPrice + " vs price in Cart " + priceInCart);
        if (SingleProductPage.singleProductPrice == priceInCart) {
            System.out.println("Prices are match");
        } else {
            System.out.println("Prices not match");
        }
    }

    public void clickCheckOut() {
        CHECKOUT_BUTTON.clickAndWait();
    }
}