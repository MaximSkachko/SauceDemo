package sauceDemo.tests;

import framework.BaseTest;
import framework.PropertyReader;
import org.testng.annotations.Test;
import sauceDemo.pageObject.*;

public class E2ETest extends BaseTest {

    @Test
    public void e2eTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUserName(PropertyReader.getProperty("user.name"));
        loginPage.setPassword(PropertyReader.getProperty("password"));
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage();
        productsPage.clickOnProductName();
        productsPage.isCounterDisplayed();

        SingleProductPage singleProductPage = new SingleProductPage();
        singleProductPage.itemValidation();
        singleProductPage.itemPriceValidation();
        singleProductPage.clickAddToCartButton();
        singleProductPage.isRemoveButtonDisplayed();
        productsPage.isCounterDisplayed();
        productsPage.isCounterNotEqualZero();
        productsPage.clickOnCartIcon();

        CartPage cart = new CartPage();
        cart.itemNameInCartValidation();
        cart.itemPriceValidation();
        cart.clickCheckOut();
        CheckOutInformationPage checkOutInformation = new CheckOutInformationPage();
        checkOutInformation.setFirstName("Maxim");
        checkOutInformation.setLastName("Test");
        checkOutInformation.setZipPostalCode("123-bb-123");
        checkOutInformation.clickContinue();

        CheckOutOverviewPage checkOutOverview = new CheckOutOverviewPage();
        checkOutOverview.itemNamesValidation();
        checkOutOverview.itemPriceValidation();
        checkOutOverview.AreTaxesApplied();
        checkOutOverview.clickFinish();

        OrderCompletedPage orderCompletedPage = new OrderCompletedPage();
        orderCompletedPage.isCompletedTextCorrect();
        orderCompletedPage.clickBackHome();
    }
}