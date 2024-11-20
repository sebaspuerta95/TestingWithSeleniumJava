package forgotPassword;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import pages.ForgotPasswordPage;
import pages.EmailSentPage;

/**
* This test class contains a simple test that consists in sending a password recovery request and grabbing a message from the page. 
* It is related to {@link ForgotPasswordPage } and {@link EmailSentPage } at src/main/pages
*
* This test will always fail because the EmalSentPage is curently broken at the server.
*/
public class ForgotPasswordTests extends BaseTestsTAU {

    // 
    @Test
    public void testRetrievePassword(){
        var forgotPass = homePage.clickForgotPassword();
        var emailSentPage = forgotPass.retrievePassword("sebas@gmail.com");
        assertEquals(emailSentPage.getContentText(), "Your e-mail's been sent!", "Texts do not match.");
    }

}
