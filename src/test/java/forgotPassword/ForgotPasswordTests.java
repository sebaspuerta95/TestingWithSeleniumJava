package forgotPassword;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * This class shows a simple test of a password recovery.
 * It is related to {@link pages.ForgotPasswordPage} at src/main/pages.
 */
public class ForgotPasswordTests extends BaseTestsTAU {

    /** This test will always fail because the EmalSentPage is currently broken.
    * This test tests that the appropriate recovery message is displayed.
    */
    @Test
    public void testRetrievePassword(){
        var forgotPass = homePage.clickForgotPassword();
        var emailSentPage = forgotPass.retrievePassword("sebas@gmail.com");
        assertEquals(emailSentPage.getContentText(), "Your e-mail's been sent!", "Texts do not match.");
    }

}
