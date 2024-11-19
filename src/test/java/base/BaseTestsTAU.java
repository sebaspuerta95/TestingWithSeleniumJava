package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.CookieManager;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTestsTAU {

    protected WebDriver driver;
    protected HomePage homePage;

    /**
     * The set-up could be done in only one @BeforeClass, but all the @Before annotations
     * were include to demonstrate how they could be used together.
     */

    @BeforeSuite
    public void browserSetUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Chrome is being set up properly before every suite.
    }

    @BeforeTest
    public void openBrowser () {
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        // Then, the browser is opened at the beginning of every test group.
        /**
         * An implicit wait can be added here to manage synchronization problems as follows:
         * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30))
         */
    }

    @BeforeClass
    public void goToHomePage(){
        goHome();
        // This method is useful if multiple classes are run within the same XML file.
        // Preconditions can be written at this point.
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        // Tests start at the home page, so we need to return to it.
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        // The objective of this method is to take screenshots automatically at test failure, but could be set up to every run.
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,
                        new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        // options.addArguments("--headless=new");
        return options;
    }

}
