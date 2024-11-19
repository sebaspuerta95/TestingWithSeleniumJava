package keyPresses;

import base.BaseTestsTAU;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeyPressesTests extends BaseTestsTAU {

    @Test
    public void testBackspace(){
        var keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("5"+ Keys.BACK_SPACE);
        assertEquals(keyPressesPage.getResultText(), "You entered: BACK_SPACE", "Incorrect message");
    }

}
