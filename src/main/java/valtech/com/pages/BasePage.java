package valtech.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import valtech.com.utils.WebElementWait;

public class BasePage {
    protected WebDriver driver;
    protected WebElementWait webElementWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webElementWait = new WebElementWait(driver);
    }

    public void open(String url) {
        driver.get(url);
    }

    WebElement waitVisibilityOf(WebElement webElement) {
        return webElementWait.waitVisibilityOf(webElement);
    }

}

