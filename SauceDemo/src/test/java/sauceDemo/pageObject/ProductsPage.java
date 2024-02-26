package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.*;
import org.openqa.selenium.*;
import java.util.*;

import static framework.Browser.getDriver;

public class ProductsPage extends BasePage {

    public static final String PAGE_LOCATOR = "//span[@class='title' and text()='Products']";
    private static final List<String> PRODUCTS_LIST = new TextBox(By.xpath("//div[@class='inventory_list']//a/div")).getElements().stream().map(WebElement::getText).toList();
    private static final String PRODUCT_ITEM = "//div[@class='inventory_list']//a/div[text()='%s']";
    private static final String PRODUCT_FULL_PRICE = "//a/div[text()='%s']/../../..//div[@class='inventory_item_price']";
    private static final String ITEMS_COUNT = "//span[@class='shopping_cart_badge']";
    private static final Image SHOPPING_CART_ICON = new Image(By.xpath("//a[@class='shopping_cart_link']"));
    public static String productName;
    public static double productPrice;
    int i = new Random().nextInt(1,PRODUCTS_LIST.size());

    public ProductsPage() {
        super(By.xpath(PAGE_LOCATOR), "Products Page");
        productName = PRODUCTS_LIST.get(i-1);
        productPrice = Double.parseDouble(getDriver().findElement(By.xpath(String.format(PRODUCT_FULL_PRICE, productName)))
                .getText().replace("$", ""));
    }

    public static Double getProductPrice() {
        return productPrice;
    }

    public void clickOnProductName() {
        TextBox product = new TextBox(By.xpath(String.format(PRODUCT_ITEM,productName)));
        product.click();
        System.out.println("click on product. Selected product is " + productName);
    }

    public void isCounterDisplayed(){
        TextBox itemsCount = new TextBox(By.xpath(ITEMS_COUNT));
        if(itemsCount.isEmpty()) {
            System.out.println("No items in the cart");
        }else {
            System.out.println("At least one item in the cart");
        }
    }

    public void isCounterNotEqualZero(){
       Image itemsCount = new Image(By.xpath(ITEMS_COUNT));
         int actualCount = Integer.parseInt(itemsCount.getText());
         if (actualCount == 0) {
             System.out.println("Something went wrong. Value cannot be 0 after adding an item ");
             System.out.println("Actual count is" + actualCount);
         } else {
             System.out.println("Counter is increased. Actual value is " + actualCount);
             System.out.println("Actual count is " + actualCount);
         }
    }

         public void clickOnCartIcon(){
             System.out.println(SHOPPING_CART_ICON.getAttribute("class"));
        SHOPPING_CART_ICON.clickAndWait();
             System.out.println("Click on cart icon");
         }
}