package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.*;
import org.openqa.selenium.*;

public class SingleProductPage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='inventory_details_name large_size' and text()='%s']";
    private static final TextBox PRODUCT_PRICE = new TextBox(By.xpath("//div[@class='inventory_details_price']"));
    private static final TextBox PRODUCT_NAME = new TextBox(By.xpath("//div[@class='inventory_details_name large_size']"));
    private static final Button ADD_TO_CART = new Button(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
    private static final Button REMOVE = new Button(By.xpath("//div//button[@class='btn btn_secondary btn_small btn_inventory']"));
    public static String singleProductName;
    public static double singleProductPrice;

    public SingleProductPage() {
        super(By.xpath(String.format(PAGE_LOCATOR, PRODUCT_NAME.getText())), "Single Product Page");
        singleProductName = PRODUCT_NAME.getText();
        singleProductPrice = Double.parseDouble(PRODUCT_PRICE.getText().replace("$", ""));
    }

    public void itemValidation() {
        System.out.println(ProductsPage.productName + " vs " + singleProductName);
        if (singleProductName.equals(ProductsPage.productName)) {
            System.out.println("OK");
        } else {
            System.out.println("Lox");
        }
    }

    public void itemPriceValidation() {
        System.out.println(ProductsPage.getProductPrice() + " vs " + singleProductPrice);
        if (singleProductPrice == ProductsPage.getProductPrice()) {
            System.out.println("OK price");
        } else {
            System.out.println("Lox price");
        }
    }

    public void clickAddToCartButton() {
        ADD_TO_CART.click();
        System.out.println("Click on 'ADD TO CART' button");
    }

    public void isRemoveButtonDisplayed() {
        REMOVE.isDisplayed();
        System.out.println("Is remove button displayed? " + REMOVE.isDisplayed());
    }
}