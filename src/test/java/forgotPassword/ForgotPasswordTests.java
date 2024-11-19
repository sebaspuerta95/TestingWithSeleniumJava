package forgotPassword;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTestsTAU {

    // This test will always fail because the EmalSentPage is broken.
    @Test
    public void testRetrievePassword(){
        var forgotPass = homePage.clickForgotPassword();
        var emailSentPage = forgotPass.retrievePassword("sebas@gmail.com");
        assertEquals(emailSentPage.getContentText(), "Your e-mail's been sent!", "Texts do not match.");
    }

}
