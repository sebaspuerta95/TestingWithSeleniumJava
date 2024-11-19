package login;

import base.BaseTestsTAU;
import pages.LoginPage;
import pages.SecureAreaPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTestsTAU {

    @Test
    public void testSuccessfulLogin (){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage securePage = loginPage.clickLoginButton();
        assertTrue(securePage.getAlertText().contains("You logged into a secure area!"), "Incorrect alert text");
    }

}
