package frames;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class FramesTests extends BaseTestsTAU {

    @Test
    public void testIncreaseIndentation(){
        var editorPage = homePage.clickWYSIWYGEditor();
        editorPage.clearTextArea();
        String text1 = "Hello ";
        String text2 = "world";
        editorPage.writeTextArea(text1);
        editorPage.increaseIndentation();
        editorPage.writeTextArea(text2);
        assertEquals(editorPage.getFrameText(), text1+text2, "Incorrect frame text.");
    }

    @Test
    public void testLeftAndBottomFrames(){
        var nestedFrames = homePage.clickNestedFrames();
        assertEquals(nestedFrames.getLeftFrameText(), "LEFT", "Incorrect frame text.");
        assertEquals(nestedFrames.getBottomFrameText(), "BOTTOM", "Incorrect frame text.");
    }

}
