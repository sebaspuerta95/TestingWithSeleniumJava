package waits;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTestsTAU {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage1 = homePage.clickDynamicLoading().clickExample1();
        loadingPage1.clickStartButtonExample1();
        assertEquals(loadingPage1.getLoadedText1(), "Hello World!", "Incorrect loaded text.");
    }

    @Test
    public void testWaitUntilVisible(){
        var loadingPage2 = homePage.clickDynamicLoading().clickExample2();
        loadingPage2.clickStartButtonExample2();
        assertEquals(loadingPage2.getLoadedText2(), "Hello World!", "Incorrect loaded text.");
    }

}
