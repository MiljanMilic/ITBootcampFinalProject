package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseTest {
    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "title")
    public WebElement pageTitle;
    @FindBy(className = "app_logo")
    public WebElement pageLogo;
    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartButton;
    @FindBy(css = ".btn")
    public WebElement addToCartButton;



    //--------------------------------

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }
    public void clickOnShoppingCartButton(){
        shoppingCartButton.click();
    }
}
