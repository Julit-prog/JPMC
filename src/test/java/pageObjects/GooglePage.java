package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

public class GooglePage {

    public WebDriver webDriver;
    public GooglePage(WebDriver driver){

        webDriver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy (name = "q")
    @CacheLookup
    WebElement searchbox;

    @FindBy (xpath = "//center/input")
    @CacheLookup
    WebElement googleSearch;

    public void setSearchString(String string){
        searchbox.clear();
        searchbox.sendKeys(string);
    }
    public void clickGoogleSearch(){

        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//center/input")));
        googleSearch.click();

    }
    public void clickOnFirstLink(){

        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("g")));

        List<WebElement> links = webDriver.findElements(By.className("g"));
        WebElement link = links.get(0).findElement(By.tagName("a"));
        link.click();
    }

    public void waitForPageLoad(){

        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(new Function<WebDriver, Object>() {
            public Object apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

}
