package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest {
    public CartPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;
    @FindBy(css = "btn.btn_secondary.btn_small.cart_button")
    public WebElement removeButton;
    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    //--------------------------------

    public void clickOnContinueShoppingButton(){
        scrollToElement(continueShoppingButton);
        continueShoppingButton.click();
    }
    public void clickOnRemoveButton(){
        removeButton.click();
    }
    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
}
