package valtech.com.core;

import org.testng.annotations.Test;
import valtech.com.pages.SiteNavigationElement;
import valtech.com.pages.SiteNavigationMainContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ValtechTests extends TestBase {

    public static final String PARTNERS = "Partners";
    public static final List<String> expectedHamburgerItemsList = new ArrayList<>(Arrays
            .asList("Work", "Contact Us", "Partners", "Insights", "UK Public Sector", "Industries", "Services", "Career", "About", "Covid19"));

    public static final List<String> expectedPartnersExperienceSection = new ArrayList<>(Arrays
            .asList("adobe", "episerver", "sitecore-experience-platform", "bloomreach", "contentstack", "contentful"));
    public static final List<String> expectedPartnersCommerceSection = new ArrayList<>(Arrays
            .asList("sap-hybris", "salesforce-commerce-cloud", "sitecore-experience-commerce", "episerver", "magento", "commercetools", "inriver", "coveo", "vtex"));
    public static final List<String> expectedPartnersMarketingAndDataSection = new ArrayList<>(Arrays
            .asList("adobe", "salesforce-commerce-cloud", "siteimprove"));
    public static final List<String> expectedPartnersCloudSection = new ArrayList<>(Arrays
            .asList("microsoft"));

    public static final String EXPERIENCE = "Experience";
    public static final String COMMERCE = "Commerce";
    public static final String MARKETING_AND_DATA = "Marketing & Data";
    public static final String CLOUD = "Cloud";

    @Test
    public void test() {
        SiteNavigationElement siteNavigationElement = new SiteNavigationElement(driver);
        siteNavigationElement.clickHamburgerMenuButton();
        assertEquals(siteNavigationElement.getMainHamburgerItemsList(), expectedHamburgerItemsList);
        siteNavigationElement.clickHamburgerMenuItemByName(PARTNERS);
        SiteNavigationMainContainer siteNavigationMainContainer = new SiteNavigationMainContainer(driver);
        siteNavigationMainContainer.clickOurPartnerTopButton();

        assertEquals(siteNavigationMainContainer.getPartnersNameBySectionName(EXPERIENCE), expectedPartnersExperienceSection);
        assertEquals(siteNavigationMainContainer.getPartnersNameBySectionName(COMMERCE), expectedPartnersCommerceSection);
        assertEquals(siteNavigationMainContainer.getPartnersNameBySectionName(MARKETING_AND_DATA), expectedPartnersMarketingAndDataSection);
        assertEquals(siteNavigationMainContainer.getPartnersNameBySectionName(CLOUD), expectedPartnersCloudSection);
    }
}
