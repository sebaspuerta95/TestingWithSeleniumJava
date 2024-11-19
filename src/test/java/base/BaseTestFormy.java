package base;

import formy.FormyPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestFormy {

    protected WebDriver driver;
    protected FormyPage formyPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        formyPage = new FormyPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
