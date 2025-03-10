package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

    private AndroidDriver driver;
    private WebDriverWait wait;


    private By addtocart=By.xpath("//android.widget.Button[@resource-id=\"blibli.mobile.commerce:id/btn_add_to_bag\"]");
    private By add=By.xpath("//android.widget.Button[@resource-id=\"blibli.mobile.commerce:id/btn_add_to_bag\"]");
    private By viewBag=By.xpath("//android.widget.LinearLayout[@resource-id=\"blibli.mobile.commerce:id/btn_view_bag\"]");
    private By checkout=By.xpath("//android.widget.Button[@resource-id=\"blibli.mobile.commerce:id/bt_checkout\"]");
    private By pay=By.xpath("//android.widget.Button[@resource-id=\"blibli.mobile.commerce:id/btn_pay\"]");
    private By orderID=By.xpath("//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_order_number\"]");
    private By refresh=By.xpath("//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_recheck_status\"]");
    private By close=By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]");
    private By image=By.xpath("//android.widget.ImageView[@resource-id=\"blibli.mobile.commerce:id/iv_status\"]");
    private By Thankyou=By.xpath("//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_payment_status\"]");

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }


    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    private WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void addToCart() {
        waitForElement(addtocart).click();
        waitForElement(add).click();
    }


    public void proceedToCheckout() {
        waitForElement(viewBag).click();
        waitForElement(checkout).click();
    }


    public void placeOrder() {
        waitForElement(pay).click();
    }

    public String getOrderID() {
        return waitForElementToBeVisible(orderID).getText();
    }
    public void VerifyOrder(){
        waitForElement(refresh).click();
        waitForElementToBeVisible(close);
        waitForElement(close).click();

    }
    public boolean Tick(){
        return waitForElementToBeVisible(image).isDisplayed();
    }
    public String message() {
        return waitForElementToBeVisible(Thankyou).getText();
    }

}
