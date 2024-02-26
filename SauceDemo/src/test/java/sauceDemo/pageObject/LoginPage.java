package sauceDemo.pageObject;

import framework.*;
import framework.elements.*;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='login-box']";
    private static final TextBox USER_NAME = new TextBox(By.xpath("//input[@id='user-name']"));
    private static final TextBox PASSWORD = new TextBox(By.xpath("//input[@id='password']"));
    private static final Button LOGIN_BUTTON = new Button(By.xpath("//input[@id='login-button']"));

    public LoginPage() {
        super(By.xpath(PAGE_LOCATOR), "Login Page");
    }

    public void setUserName(String userName) {
        USER_NAME.sendKeys(userName);
    }

    public void setPassword(String password) {
        PASSWORD.sendKeys(password);
    }

    public void clickLoginButton() {
        LOGIN_BUTTON.clickAndWait();
    }
}