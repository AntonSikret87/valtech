package valtech.com.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import valtech.com.utils.WebElementWait;

public class BasePage {
    public static final String COOKIE_NAME = "CookieConsent";
    public static final String COOKIE_VALUE = "{stamp:%27Hut2F6fbvz+QJpa9+/i3TMiV14LTWTIki1TnVssK9UoYAYXoUOi+Gg==%27%2Cnecessary:true%2Cpreferences:false%2Cstatistics:false%2Cmarketing:false%2Cver:2%2Cutc:1597590542210%2Cregion:%27ua%27}";
    protected WebDriver driver;
    protected WebElementWait webElementWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webElementWait = new WebElementWait(driver);
    }

    public void open(String url) {
        driver.get(url);
        driver.manage().getCookies();
        driver.manage().addCookie(new Cookie(COOKIE_NAME, COOKIE_VALUE));
        driver.navigate().refresh();
    }


    public WebElement waitVisibilityOf(WebElement webElement) {
        return webElementWait.waitVisibilityOf(webElement);
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


}

