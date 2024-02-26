package sauceDemo.pageObject;

import framework.*;
import framework.elements.*;
import org.openqa.selenium.By;

public class CheckOutInformationPage extends BasePage {
    private static final String PAGE_LOCATOR = "//span[@class='title' and text()='Checkout: Your Information']";
    private static final TextBox FIRST_NAME = new TextBox(By.xpath("//input[@name='firstName']"));
    private static final TextBox LAST_NAME = new TextBox(By.xpath("//input[@name='lastName']"));
    private static final TextBox ZIP_POSTAL_CODE = new TextBox(By.xpath("//input[@name='postalCode']"));
    private static final Button CONTINUE = new Button(By.xpath("//input[@type='submit']"));

    public CheckOutInformationPage() {
        super(By.xpath(PAGE_LOCATOR), "Checkout: Your Information Page");
    }

    public void setFirstName(String firstName) {
        FIRST_NAME.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        LAST_NAME.sendKeys(lastName);
    }

    public void setZipPostalCode(String postalCode) {
        ZIP_POSTAL_CODE.sendKeys(postalCode);
    }

    public void clickContinue() {
        CONTINUE.clickAndWait();
    }
}