package valtech.com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class WebElementWait {

    private WebDriverWait webDriverWait;

    public WebElementWait(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 25);
    }

    public WebElement waitVisibilityOf(WebElement webElement) {
        return webDriverWait.until(visibilityOf(webElement));
    }

}
