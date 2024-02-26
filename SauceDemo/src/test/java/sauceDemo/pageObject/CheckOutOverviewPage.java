package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.*;
import org.openqa.selenium.By;

public class CheckOutOverviewPage extends BasePage {
    private static final String PAGE_LOCATOR = "//span[@class='title' and text()='Checkout: Overview']";
    private static final Button FINISH = new Button(By.xpath("//button[@data-test='finish']"));
    private static final TextBox ITEM_NAME_OVERVIEW = new TextBox(By.xpath("//div[@class='inventory_item_name']"));
    private static final TextBox ITEM_PRICE_OVERVIEW = new TextBox(By.xpath("//div[@class='inventory_item_price']"));
    private static final TextBox TOTAL_PRICE_WITH_TAXES = new TextBox(By.xpath("//div[@class='summary_info_label summary_total_label']"));
    private static String itemNameOverview;
    private static double itemPriceOverview;
    private static double totalPriceWithTaxes;

    public CheckOutOverviewPage() {
        super(By.xpath(PAGE_LOCATOR), "Checkout. Overview page");
        itemNameOverview = ITEM_NAME_OVERVIEW.getText();
        itemPriceOverview = Double.parseDouble(ITEM_PRICE_OVERVIEW.getText().replace("$", ""));
        totalPriceWithTaxes = Double.parseDouble(TOTAL_PRICE_WITH_TAXES.getText().replaceAll("[A-Za-z:$]", ""));
    }

    public void itemNamesValidation() {
        System.out.println("Item selected: " + ProductsPage.productName + " vs Item in Card: " +
                SingleProductPage.singleProductName + " vs Item in cart: " + CartPage.itemNameInCart + " Item Name Overview: " + itemNameOverview);
        if (CartPage.itemNameInCart.equals(itemNameOverview)) {
            System.out.println("Names are match");
        } else {
            System.out.println("Not Match");
        }
    }

    public void itemPriceValidation() {
        System.out.println("Selected item Price: " + ProductsPage.getProductPrice() + " vs Price in Card: " +
                SingleProductPage.singleProductPrice + " vs price in Cart " + CartPage.priceInCart + " Item Price Overview: " + itemPriceOverview);
        if (CartPage.priceInCart == itemPriceOverview) {
            System.out.println("Prices are match");
        } else {
            System.out.println("Prices not match");
        }
    }

    public boolean AreTaxesApplied() {
        if (totalPriceWithTaxes > itemPriceOverview) {
            System.out.println("Taxes are applied");
            return true;
        } else {
            System.out.println(totalPriceWithTaxes + " " + " " + itemPriceOverview);
            System.out.println("Price with taxes is equal or less than initial price");
        }
        return false;
    }

    public void clickFinish() {
        FINISH.clickAndWait();
    }
}