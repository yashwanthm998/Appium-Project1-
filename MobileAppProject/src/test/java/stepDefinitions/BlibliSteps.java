package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.SearchPage;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class BlibliSteps {


    public AndroidDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;
    CheckoutPage checkoutPage;

    @Given("User is on Home page")
    public void User_is_on_Home_page() throws MalformedURLException {

        String appiumServerUrl = "http://127.0.0.1:4750/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:appPackage", "blibli.mobile.commerce");
        capabilities.setCapability("appium:appActivity", "blibli.mobile.ng.commerce.core.init.view.SplashActivity");
        capabilities.setCapability("appium:noReset", true);

        driver = new AndroidDriver(new URL(appiumServerUrl), capabilities);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    @When("User enters {string} and {string} to Login")
    public void userEntersAnd(String username, String password) {

        loginPage.clickLoginButton();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

    }

    @And("User searches for {string} on search bar")
    public void userSearchesFor(String product) {
        searchPage.searchProduct(product);
        searchPage.firstProduct();
    }


    @And("User adds the product to cart")
    public void userAddsTheProductToCart() {
        checkoutPage.addToCart();
        checkoutPage.proceedToCheckout();
        checkoutPage.placeOrder();
    }


    @And("Confirming order using API")
    public void iSendAGETRequestTo() {
        Response response = given()
                .baseUri("http://np-qa-tools-02.gdn-app.com:8084/api/approve/orderId")
                .header("Content-Type", "application/json")
                .queryParam("orderId", checkoutPage.getOrderID())
                .queryParam("environment","PREPROD")
                .when()
                .get();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Then("User verifies the order ID")
    public void userVerifiesTheOrderID() {
        System.out.println("Order ID: " + checkoutPage.getOrderID());
        checkoutPage.VerifyOrder();
        Assert.assertEquals(checkoutPage.Tick(),true,"Order not placed");
        Assert.assertEquals(checkoutPage.message(),"Thank you for shopping!");
        System.out.println(checkoutPage.message());
    }
}

