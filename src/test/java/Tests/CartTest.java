package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        homePage();
    }
    @Test
    public void addItemToCart(){
        productsPage.clickOnAddToCartButton();
        String expectedNumberInCart = "1";
        Assert.assertEquals(productsPage.shoppingCartButton.getText(), expectedNumberInCart);
        

    }
}
