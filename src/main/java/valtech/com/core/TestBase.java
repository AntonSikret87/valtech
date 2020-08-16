package valtech.com.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import valtech.com.pages.BasePage;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private String baseUrl = "https://www.valtech.co.uk/";
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass()
    public void setUp(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        setWebDriverSettings();
        goToUrl(baseUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    private void setWebDriverSettings() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }

    private void goToUrl(String baseUrl) {
        BasePage basePage = new BasePage(driver);
        basePage.open(baseUrl);
    }

}

