
package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

private By searchBar= By.xpath("//android.widget.TextSwitcher[@resource-id=\"blibli.mobile.commerce:id/tv_search\"]");
private By searchButton=By.xpath("//android.widget.ImageView[@resource-id=\"blibli.mobile.commerce:id/iv_search_button\"]");
private By firstProduct = By.xpath("(//android.view.ViewGroup[@resource-id=\"blibli.mobile.commerce:id/cl_parent\"])[1]");
private By sear=By.xpath("//android.widget.EditText[@resource-id=\"blibli.mobile.commerce:id/et_search_box\"]");
    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        WebElement sea = wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        sea.click();
        driver.findElement(sear).sendKeys(productName);
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
    }


    public void firstProduct() {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        product.click();
    }
}
