package alerts;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContextMenuTests extends BaseTestsTAU {

    @Test
    public void testContextBoxAlert(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnBox();
        String message = contextMenuPage.getContextAlertText();
        contextMenuPage.acceptContextAlert();
        assertEquals(message, "You selected a context menu", "Incorrect alert message. ");
    }
}
