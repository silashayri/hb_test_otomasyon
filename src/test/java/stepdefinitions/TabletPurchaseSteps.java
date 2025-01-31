package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import org.junit.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import utilities.Driver;

public class TabletPurchaseSteps {
    private WebDriver driver;
    private HomePage homePage;
    private TabletPage tabletPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private String productDetailPrice;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        tabletPage = new TabletPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
    }

    @Given("Kullanıcı Hepsiburada ana sayfasına gider")
    public void kullanıcı_hepsiburada_ana_sayfasına_gider() {
        driver.get("https://www.hepsiburada.com/");
    }

    @When("Tablet kategorisine gider")
    public void tablet_kategorisine_gider() throws InterruptedException {
        homePage.navigateToTabletCategory();
    }

    @When("Apple ve 13.2 inç filtrelerini seçer")
    public void apple_ve_inç_filtrelerini_seçer() throws InterruptedException {
        tabletPage.selectFilters();
    }

    @When("En pahalı ürüne tıklar")
    public void en_pahalı_ürüne_tıklar() throws InterruptedException {
        tabletPage.clickMostExpensiveProduct();
        productDetailPrice = productDetailPage.getProductPrice().replaceAll("[^0-9,]", "")
                .replace(",", ".");
        ;
    }

    @When("Ürünü sepete ekler")
    public void ürünü_sepete_ekler() throws InterruptedException {
        productDetailPage.addToCart();
    }

    @Then("Ürünün sepete eklendiği doğrulanır")
    public void ürünün_sepete_eklendiği_doğrulanır() {
        String cartPrice = cartPage.getCartProductPrice();
        Assert.assertNotNull("Sepette ürün fiyatı bulunamadı", cartPrice);
    }

    @Then("Sepetteki fiyat ürün detay sayfasındaki fiyat ile aynı olmalıdır")
    public void sepetteki_fiyat_ürün_detay_sayfasındaki_fiyat_ile_aynı_olmalıdır() {
        String cartPrice = cartPage.getCartProductPrice().replaceAll("[^0-9,]", "")
                .replace(",", ".");
        Assert.assertEquals("Fiyatlar eşleşmiyor", productDetailPrice, cartPrice);
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
} 