package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BurgerMenuTest extends BaseTest {

    String numberInCartAfterAdd = "1";
    String numberInCartAfterReset = "";

    @BeforeMethod
    public void pageSetUp() {
        homePage();
    }

    @Test
    public void allItemsTest() {
        productsPage.clickOnShoppingCartButton();
        navigationBar.clickOnBurgerMenuButton();
        navigationBar.clickOnAllItems();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test
    public void aboutTest() {
        navigationBar.clickOnBurgerMenuButton();
        navigationBar.clickOnAbout();
        String expectedURL = "https://saucelabs.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test
    public void logoutTest() {
        navigationBar.clickOnBurgerMenuButton();
        navigationBar.clickOnLogout();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test
    public void resetAppStateTest() {
        productsPage.clickOnAddToCartButton();
        Assert.assertEquals(productsPage.shoppingCartIcon.getText(), numberInCartAfterAdd);
        navigationBar.clickOnBurgerMenuButton();
        navigationBar.clickOnReset();
        Assert.assertEquals(productsPage.shoppingCartIcon.getText(), numberInCartAfterReset);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
