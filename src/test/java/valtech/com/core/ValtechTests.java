package valtech.com.core;

import org.testng.Assert;
import org.testng.annotations.Test;
import valtech.com.pages.SiteNavigationElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValtechTests extends TestBase {

    public static final String PARTNERS = "Partners";
    public static final List<String> expectedHamburgerItemsList =
            new ArrayList<>(Arrays.asList("Work", "Contact Us", "Partners", "Insights", "UK Public Sector", "Industries", "Services", "Career", "About", "Covid19"));

    @Test
    public void test() {
        SiteNavigationElement siteNavigationElement = new SiteNavigationElement(driver);
        siteNavigationElement.clickHamburgerMenuButton();
        Assert.assertEquals(siteNavigationElement.getMainHamburgerItemsList(), expectedHamburgerItemsList);
        siteNavigationElement.clickHamburgerMenuItemByName(PARTNERS);
    }
}
