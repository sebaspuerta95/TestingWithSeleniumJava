package academyBugs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseAB {

    protected WebDriver driver;
    protected RegistrationPage regPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://academybugs.com/account/?ec_page=register");
        driver.manage().window().maximize();
        regPage = new RegistrationPage(driver);
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

}
