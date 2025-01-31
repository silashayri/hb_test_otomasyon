package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='basket_payedPrice']/span")
    private WebElement cartProductPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCartProductPrice() {
        return cartProductPrice.getText();
    }
} 