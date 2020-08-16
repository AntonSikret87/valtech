package valtech.com.core;

import org.testng.annotations.Test;
import valtech.com.pages.SiteNavigationElement;
import valtech.com.pages.SiteNavigationMainContainerElement;
import valtech.com.pages.UkPublicSectorPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ValtechTests extends TestBase {

    public static final String EXPERIENCE = "Experience";
    public static final String COMMERCE = "Commerce";
    public static final String MARKETING_AND_DATA = "Marketing & Data";
    public static final String CLOUD = "Cloud";
    public static final String CONTACT_US_URL = "https://www.valtech.com/en-gb/about/contact-us/";
    public static final String UK_PUBLIC_SECTOR = "UK Public Sector";
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

    @Test
    public void test() {
        //Exercise #1
        SiteNavigationElement siteNavigationElement = new SiteNavigationElement(driver);
        //Exercise #2
        siteNavigationElement.clickHamburgerMenuButton();
        assertEquals(siteNavigationElement.getMainHamburgerItemsList(), expectedHamburgerItemsList);
        siteNavigationElement.clickHamburgerMenuItemByName(PARTNERS);
        SiteNavigationMainContainerElement siteNavigationMainContainerElement = new SiteNavigationMainContainerElement(driver);
        siteNavigationMainContainerElement.clickOurPartnerTopButton();
        assertEquals(siteNavigationMainContainerElement.getPartnersNameBySectionName(EXPERIENCE), expectedPartnersExperienceSection);
        assertEquals(siteNavigationMainContainerElement.getPartnersNameBySectionName(COMMERCE), expectedPartnersCommerceSection);
        assertEquals(siteNavigationMainContainerElement.getPartnersNameBySectionName(MARKETING_AND_DATA), expectedPartnersMarketingAndDataSection);
        assertEquals(siteNavigationMainContainerElement.getPartnersNameBySectionName(CLOUD), expectedPartnersCloudSection);
        //Exercise #3
        siteNavigationElement.clickHamburgerMenuButton();
        siteNavigationElement.clickHamburgerMenuItemByName(UK_PUBLIC_SECTOR);
        //Was not able to get "list of all public sector customers" because it was just an image (save into \src\test\resources\client-logos.png )
        UkPublicSectorPage ukPublicSectorPage = new UkPublicSectorPage(driver);
        ukPublicSectorPage.clickTalkToUsButton();
        assertEquals(driver.getCurrentUrl(), CONTACT_US_URL);
    }
}
