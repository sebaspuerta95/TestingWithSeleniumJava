package alerts;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

/**
* This test class shows how to interact with JavaScript alerts using switchTo() method. 
* This class is related to {@link AlertsPage } class (src/main/pages)
* As tests are run in ascending alphabetical order by default, the priority attribute of the test annotation is used to control the order of execution. 
*/ 
public class JSAlertsTests extends BaseTestsTAU {

    /** 
    * This method consist in clicking the Alert button, accepting the alert and checking that the correct message is displayed. 
    */ 
    @Test (priority = 3, groups = "jsAlerts")
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.click_alertButton();
        alertsPage.alert_acceptAlert();
        assertEquals(alertsPage.getResultText(), "You successfully clicked an alert", "Incorrect alert message.");
    }

    /** 
    * This method consist in clicking the Confirm button, dismissing the alert and checking that the correct message is displayed. 
    */
    @Test (priority = 2, groups = "jsAlerts")
    public void testDismissAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.click_confirmButton();
        alertsPage.alert_dismissAlert();
        assertEquals(alertsPage.getResultText(), "You clicked: Cancel", "Incorrect alert message.");
    }

    /** 
    * This method consist in clicking the Prompt button, sending keys the alert and checking that the correct message is displayed. 
    */
    @Test (priority = 1, groups = "jsAlerts")
    public void testSendKeys(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.click_promptButton();
        assertEquals(alertsPage.alert_getAlertText(), "I am a JS prompt", "Incorrect alert message.");
        String text = "hi";
        alertsPage.alert_sendText(text);
        alertsPage.alert_acceptAlert();
        assertEquals(alertsPage.getResultText(), "You entered: hi", "Incorrect alert message.");
    }

}
