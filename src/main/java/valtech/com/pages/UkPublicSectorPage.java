package valtech.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UkPublicSectorPage extends BasePage {

    @FindBy(css = ".next-block__container a")
    private WebElement talkToUsButton;

    public UkPublicSectorPage(WebDriver driver) {
        super(driver);
    }

    public void clickTalkToUsButton() {
        scrollDown();
        talkToUsButton.click();
    }

}
