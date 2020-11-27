package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.GooglePage;

import java.util.function.Function;

public class SearchJPMSteps {
    WebDriver driver;
    GooglePage page;

    @Given("User launches a browser")
    public void userLaunchesABrowser() {
        System.setProperty("webdriver.firefox.driver", System.getProperty("user") + "//Drivers//gecodriver.exe");
        driver = new FirefoxDriver();
        page = new GooglePage(driver);
    }

    @When("User opens google")
    public void userOpensGoogle() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @And("User searches string {string}")
    public void enterTheSearchStringJPMorgan(String searchString) {
        page.setSearchString(searchString);
        page.clickGoogleSearch();
    }

    @And("User clicked on first link")
    public void userClickedOnFirstLink() throws InterruptedException {
        page.clickOnFirstLink();
        page.waitForPageLoad();

    }

    @Then("Verify J P Morgan Logo should be present")
    public void jPMorganLogoShouldBePresent() {

        Boolean logo;
        try{
            logo =driver.findElement(By.className("first-logo")).isEnabled();
        }catch (Exception e) {
             logo =false;
        }
        Assert.assertTrue("Logo not present", logo);
    }

    @And("close the browser")
    public void closeTheBrowser() {
        driver.close();
    }
}
