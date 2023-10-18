package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    String numberInCartAfterAdd = "1";
    String numberInCartAfterRemove = "";

    @BeforeMethod
    public void pageSetUp() {
        homePage();
    }

    @Test(priority = 10)
    public void addRemoveItemToCart() {
        productsPage.clickOnAddToCartButton();
        Assert.assertEquals(productsPage.shoppingCartIcon.getText(), numberInCartAfterAdd);
        productsPage.clickOnRemoveButton();
        Assert.assertEquals(productsPage.shoppingCartIcon.getText(), numberInCartAfterRemove);
    }

    @Test(priority = 20)
    public void continueShoppingFromCart() {
        productsPage.clickOnAddToCartButton();
        Assert.assertEquals(productsPage.shoppingCartIcon.getText(), numberInCartAfterAdd);
        productsPage.clickOnShoppingCartButton();
        cartPage.clickOnContinueShoppingButton();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 30)
    public void checkoutFromCart() {
        productsPage.clickOnAddToCartButton();
        productsPage.clickOnShoppingCartButton();
        cartPage.clickOnCheckoutButton();
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
