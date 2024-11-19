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

/**
* This is the configuration class for all the tests that are performed on the "The Internet" web page. 
* It is the starting point to set up the driver and is meant to promote code reusability and maintainability.
*/ 
public class BaseTestsTAU {

    // WebDriver and HomePage instances are protected so they can only be used by classes inside the base package and inherited methods. 
    protected WebDriver driver;
    protected HomePage homePage; 

    /**
     * The set-up could be done in only one @BeforeClass, but all the @Before annotations
     * were include to demonstrate how they could be used together.
     */

    // Chrome driver is being set up properly before every suite.
    @BeforeSuite
    public void browserSetUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    }

    // Then, the browser is opened at the beginning of every test group.
    @BeforeTest
    public void openBrowser () {
        driver = new ChromeDriver();
        // driver = new ChromeDriver(getChromeOptions()); - We can run Chrome with specific options, like headless. 
        driver.manage().window().maximize();   
        /**
         * An implicit wait can be added here to manage synchronization problems as follows:
         * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30))
         */
    }

    // This method is useful if multiple classes are run within the same XML file. Preconditions can be written at this point.
    @BeforeClass
    public void goToHomePage(){
        goHome();     
    }

    // Tests start at the home page, so we need to return to it.
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    /**
    * The objective of this method is to take screenshots automatically at test failure, but could be set up to every run.
    * Process:
    * <ol>
    *   <li>The test takes an instance of the ITestResult and verifies if the result is FAILURE to trigger this method.</li>
    *   <li>The driver is casted to a TakesScreenshot object, so a screenshot can be taken.</li>
    *   <li>The output file is stored at a specified directory, which in this case, is located within the project.</li>
    * </ol>    
    */ 
    @AfterMethod
    public void recordFailure(ITestResult result){
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

    // Closes the driver. 
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
