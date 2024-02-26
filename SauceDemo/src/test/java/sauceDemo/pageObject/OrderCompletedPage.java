package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.*;
import org.openqa.selenium.By;

public class OrderCompletedPage extends BasePage {
    private static final String PAGE_LOCATOR = "//span[@class='title' and text()='Checkout: Complete!']";
    private static final Button BACK_HOME_BUTTON = new Button(By.xpath("//button[@class='btn btn_primary btn_small']"));
    private static final TextBox COMPLETED_ORDER = new TextBox(By.xpath("//div[@class='complete-text']"));
    private static final String COMPLETED_ORDER_TEXT = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
    private static String completedText;

    public OrderCompletedPage() {
        super(By.xpath(PAGE_LOCATOR), "Checkout: Complete Page");
        completedText = COMPLETED_ORDER.getText();
    }

    public boolean isCompletedTextCorrect(){
        COMPLETED_ORDER.isDisplayed();
        if (completedText.equals(COMPLETED_ORDER_TEXT)) {
            System.out.println("Text is correct");
            return true;
        } else {
            System.out.println("Text is not correct");
        }
        return false;
    }

    public void clickBackHome(){
        BACK_HOME_BUTTON.clickAndWait();
        Label label = new Label(By.xpath(ProductsPage.PAGE_LOCATOR));
        label.isDisplayed();
    }
}