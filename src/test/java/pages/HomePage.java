package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    @FindBy(xpath = "//span[contains(text(),'Elektronik')]/..")
    private WebElement allCategoriesMenu;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(xpath = "//a[normalize-space()='Bilgisayar/Tablet']")
    private WebElement electronicsCategory;

    @FindBy(xpath = "(//a[@class='sf-ChildMenuItems-KdzkrxSVhcwDy3od0Yre item-1855']/../a)[1]")
    private WebElement tabletCategory;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToTabletCategory() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookies)).click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(allCategoriesMenu));
        actions.moveToElement(allCategoriesMenu).perform();
        Thread.sleep(500);

        wait.until(ExpectedConditions.visibilityOf(electronicsCategory));
        actions.moveToElement(electronicsCategory).perform();
        Thread.sleep(500);

        wait.until(ExpectedConditions.elementToBeClickable(tabletCategory));
        actions.moveToElement(tabletCategory).click().perform();
    }
} 