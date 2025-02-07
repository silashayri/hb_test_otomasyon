package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@data-test-id='addToCart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[normalize-space()='Sepete git']")
    private WebElement goToCartButton;

    @FindBy(xpath = "(//div[@data-test-id='price']/div/div/div/span)[1]")
    private WebElement productPrice;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForElement(String Time){
        try{
            Thread.sleep(Long.parseLong(Time));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String getProductPrice() throws InterruptedException {
        Thread.sleep(7000);
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println("Ürün Fiyatı: " + productPrice.getText());
        return productPrice.getText();

    }

    public void addToCart() {
        waitForElement(String.valueOf(5000));
        addToCartButton.click();
//        Thread.sleep(6000);
        goToCartButton.click();
//        Thread.sleep(5000);

    }
} 