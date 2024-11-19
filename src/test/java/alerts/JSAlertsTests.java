package alerts;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSAlertsTests extends BaseTestsTAU {

    // I'm using the priority attribute to control de execution order.
    // By default, tests are run in ascending alphabetical order.
    @Test (priority = 3)
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.click_alertButton();
        alertsPage.alert_acceptAlert();
        assertEquals(alertsPage.getResultText(), "You successfully clicked an alert", "Incorrect alert message.");
    }

    @Test (priority = 2)
    public void testDismissAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.click_confirmButton();
        alertsPage.alert_dismissAlert();
        assertEquals(alertsPage.getResultText(), "You clicked: Cancel", "Incorrect alert message.");
    }

    @Test (priority = 1)
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
