package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class TabletPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[@class='heroContent-wX4RJzHisIfuS5Xol0to'][normalize-space()='Apple']/..")
    private WebElement appleCheckbox;

    @FindBy(xpath = "//span[normalize-space()='13,2 inç']/..")
    private WebElement screenSizeCheckbox;

    public TabletPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void selectFilters()  {
        ProductDetailPage productpage= new ProductDetailPage(driver);
        productpage.waitForElement(String.valueOf(5000));
        clickElement(appleCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(appleCheckbox)).click();
//        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(screenSizeCheckbox)).click();
//        Thread.sleep(1000);
        driver.navigate().refresh();
//        Thread.sleep(3000);
    }

    public void clickMostExpensiveProduct() {
        List<WebElement> productCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//ul[(@id='1')]/li")));

        System.out.println("Toplam ürün sayısı: " + productCards.size());

        double maxPrice = 0;
        WebElement mostExpensiveProduct = null;
        int maxPriceIndex = -1;

        for (int i = 0; i < productCards.size(); i++) {
            try {

                String priceXPath = String.format("(//div[contains(@data-test-id, 'price-current-price')])[%d]", i + 1);
                WebElement priceElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(priceXPath)));

                String priceText = priceElement.getText()
                        .replaceAll("[^0-9,]", "")
                        .replace(",", ".");

                double price = Double.parseDouble(priceText);
                System.out.println((i + 1) + ". ürünün fiyatı: " + price);

                if (price > maxPrice) {
                    maxPrice = price;
                    maxPriceIndex = i;
                    mostExpensiveProduct = productCards.get(i);
                }
            } catch (Exception e) {
                System.out.println((i + 1) + ". ürünün fiyatı okunamadı: " + e.getMessage());
                continue;
            }
        }

        System.out.println("En yüksek fiyat: " + maxPrice + " - Index: " + (maxPriceIndex + 1));

        if (mostExpensiveProduct != null) {
            try {
                String productXPath = String.format("(//ul[(@id='1')]/li)[%d]", maxPriceIndex + 2);
                WebElement productToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
                Thread.sleep(5000);
                productToClick.click();
                productToClick.click();
            } catch (Exception e) {
                throw new RuntimeException("En pahalı ürüne tıklanamadı: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("En pahalı ürün bulunamadı");
        }
    }
} 