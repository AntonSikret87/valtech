package valtech.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class SiteNavigationElement extends BasePage {

    private static final String DISPLAY = "display";
    private static final String FLEX = "flex";
    private final static String HAMBURGER_MENU_ITEM_BY_NAME_PATTERN = ".//button[@type='button' and contains(.,'%s')]";

    @FindBy(css = ".icon-menu")
    private WebElement hamburgerMenuButton;

    @FindBy(xpath = ".//ul[@class='site-nav__menu__primary']//button[@type='button']")
    private List<WebElement> mainHamburgerItemList;

    @FindBy(css = ".site-nav__overlay__content-general")
    private WebElement hamburgerMenuActive;


    public SiteNavigationElement(WebDriver driver) {
        super(driver);
    }

    public void clickHamburgerMenuButton() {
        waitVisibilityOf(hamburgerMenuButton).click();
        isHamburgerMenuExpanded();
    }

    private boolean isHamburgerMenuExpanded() {
        waitVisibilityOf(hamburgerMenuActive);
        return hamburgerMenuActive.getCssValue(DISPLAY).equals(FLEX);
    }

    public void clickHamburgerMenuItemByName(String itemName) {
        By hamburgerItemLocator = By.xpath(format(HAMBURGER_MENU_ITEM_BY_NAME_PATTERN, itemName));
        driver.findElement(hamburgerItemLocator).click();
    }

    public List<String> getMainHamburgerItemsList() {
        return mainHamburgerItemList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
