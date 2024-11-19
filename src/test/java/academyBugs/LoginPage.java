package academyBugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By recentOrders = By.xpath("div[class*='ec_cart_header_no_border']");

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public String getLoginTitle (){
        return driver.findElement(recentOrders).getText();
    }

}
