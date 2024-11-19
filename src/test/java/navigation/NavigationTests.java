package navigation;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTestsTAU {

    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().goForward();
        getWindowManager().refreshPage();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testSwitchToNewWindow(){
        var newWindow = homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
        assertEquals(newWindow.getNWText(), "New Window", "Incorrect new window text.");
    }

    @Test
    public void testContextClick(){
        var example2Page = homePage.clickDynamicLoading().rightClickOnExample2Link();
        getWindowManager().switchToTab("https://the-internet.herokuapp.com/dynamic_loading/2");
        assertTrue(example2Page.isButtonDisplayed(), "The Start button is not displayed.");
        example2Page.clickStartButtonExample2();
        assertEquals(example2Page.getLoadedText2(), "Hello World!", "Incorrect loaded text.");
    }

}
