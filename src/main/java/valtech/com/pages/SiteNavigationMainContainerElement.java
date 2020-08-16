package valtech.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class SiteNavigationMainContainerElement extends BasePage {

    @FindBy(xpath = ".//h3/following-sibling::a[contains(@class,'button')][contains(.,'Our Partners')]")
    private WebElement topOurPartnerButton;

    private static final String PARTNERS_LIST_NAME_BY_SECTION_NAME_PATTERN =
            ".//hgroup[@class='partners-block__title'][contains(.,'%s')]//following-sibling::div/a[@class='partners-block__logo']";

    public SiteNavigationMainContainerElement(WebDriver driver) {
        super(driver);
    }

    public void clickOurPartnerTopButton() {
        waitVisibilityOf(topOurPartnerButton).click();
    }

    public List<String> getPartnersNameBySectionName(String sectionName) {
        By partnersNameListLocator = By.xpath(format(PARTNERS_LIST_NAME_BY_SECTION_NAME_PATTERN, sectionName));
        List<String> partnerNames = driver.findElements(partnersNameListLocator).stream()
                .map(el -> {
                    String href = el.getAttribute("href");
                    String[] splittedHrefValues = href.split("/");
                    return splittedHrefValues[splittedHrefValues.length - 1];
                }).collect(Collectors.toList());
        System.out.println(format("Partners names for section '%s' : ", sectionName) + partnerNames);
        return partnerNames;
    }
}
