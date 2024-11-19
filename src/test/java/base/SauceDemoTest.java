package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class SauceDemoTest {

    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By itemsClass = By.className("inventory_item_name");
    private String username = "standard_user";
    private String password = "secret_sauce";

    // This methods sets up the browser and opens the page.
    public void launchSwagsSauce() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    // This method fills the fields and clicks in login button.
    public void login(){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // This method gets the page title.
    public String getPageTitle(){
        return driver.getTitle();
    }

    // This method gets the items in the list.
    public List<WebElement> getItemsList(){
        List<WebElement> elements = driver.findElements(itemsClass);
        List<WebElement> firstFiveElements = elements.stream().limit(5).collect(Collectors.toList());
        return firstFiveElements;
    }

    public static void main(String[] args) {
        var test = new SauceDemoTest();
        test.launchSwagsSauce();
        System.out.println("The username is: standard_user and the password is: secret_sauce");
        test.login();
        String login_header = test.getPageTitle();
        System.out.println("The title of the page is: " + login_header);
        List<WebElement> itemsList = test.getItemsList();
        System.out.println("Los primeros 5 elementos son: ");
        for (WebElement element : itemsList){
            System.out.println(element.getText());
        }
    }

}
