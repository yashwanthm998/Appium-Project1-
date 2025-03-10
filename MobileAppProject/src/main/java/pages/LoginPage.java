
package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By LoginButton = By.xpath("//android.widget.Button[@resource-id=\"blibli.mobile.commerce:id/bt_login\"]");
    private By UserName = By.xpath("//android.widget.EditText");
    private By Password=By.xpath("//android.webkit.WebView[@text=\"Log in - Akun Blibli Tiket\"]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.EditText");
    private By Login = By.xpath("//android.widget.Button[@text=\"Log in\"]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        btn.click();
    }

    public void enterUsername(String username) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(UserName));
        userField.click();
        userField.sendKeys(username);
        driver.findElement(Login).click();

    }

    public void enterPassword(String password) {
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        passField.click();
        passField.sendKeys(password);
        driver.findElement(Login).click();
    }
}

