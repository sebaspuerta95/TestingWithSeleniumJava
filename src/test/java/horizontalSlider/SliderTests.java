package horizontalSlider;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * This test class demonstrates how to interact with a slider to move it until the desired point. 
 * It is related to {@link pages.HorizontalSliderPage} at src/main/pages
 */
public class SliderTests extends BaseTestsTAU {

    /**
    * In this test, we move the slider until the desired element. It is helpful when we want to test the behavior at a certain point. 
    * Process:
    * <ol>
    *   <li>Locate the horizontal slider and click on it to select it.</li>
    *   <li>Move the slider by sending a right click until it matches the desired value.</li>
    *   <li>Keys are sent while the message doesn't match the desired value.</li>
    * </ol>    
    */ 
    @Test
    public void testRightKey(){
        var horizontalSlidePage = homePage.clicHorizontalSlider();
        String value = "3.5";
        horizontalSlidePage.moveSlider(value);
        assertEquals(horizontalSlidePage.getSliderValue(), value, "Incorrect slider value.");
    }

}
