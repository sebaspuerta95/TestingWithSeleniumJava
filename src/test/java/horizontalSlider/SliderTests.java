package horizontalSlider;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTestsTAU {

    @Test
    public void testRightKey(){
        var horizontalSlidePage = homePage.clicHorizontalSlider();
        String value = "3.5";
        horizontalSlidePage.moveSlider(value);
        assertEquals(horizontalSlidePage.getSliderValue(), value, "Incorrect slider value.");
    }

}
