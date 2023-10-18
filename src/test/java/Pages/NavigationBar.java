package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends BaseTest {
    public NavigationBar() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;
    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItems;
    @FindBy(id = "about_sidebar_link")
    public WebElement about;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logout;
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState;

    //--------------------------------

    public void clickOnBurgerMenuButton() {
        burgerMenuButton.click();
    }

    public void clickOnAllItems() {
        allItems.click();
    }

    public void clickOnAbout() {
        about.click();
    }

    public void clickOnLogout() {
        logout.click();
    }

    public void clickOnReset() {
        resetAppState.click();
    }

}
