package alerts;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
* This test class is an example of usage of the Actions class to send right-clicks to element and interact with JavaScript alerts. 
* It is related to { @link ContextMenuPage } (src/main/utils). 
*/ 
public class ContextMenuTests extends BaseTestsTAU {

    /**
    * Process:
    * <ol>
    *   <li>A right-click is sent to the content box.</li>
    *   <li>A JavaScript alert is triggered and the test switches to the alert to grab the text.</li>
    *   <li>The test accepts the alert and validates that the text matches the expected result.</li>
    * </ol>    
    */ 
    @Test
    public void testContextBoxAlert(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnBox();
        String message = contextMenuPage.getContextAlertText();
        contextMenuPage.acceptContextAlert();
        assertEquals(message, "You selected a context menu", "Incorrect alert message. ");
    }
}
