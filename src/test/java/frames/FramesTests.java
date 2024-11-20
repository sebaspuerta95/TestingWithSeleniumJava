package frames;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

/**
* This test class demonstrates how to interact with iFrames, which are <html> tags inside other <html> tags, and we cannot easily locate web elements inside of it. 
* It is related to {@link WYSIWYGEditorPage } and {@link NestedFramesPageat } at src/main/pages
*/
public class FramesTests extends BaseTestsTAU {

    /** 
    * This method tests the interactions with a WYSIWYG edit (What You See Is What You Get).
    * Process: 
    * <ol>
    * <li>The test accesses the iFrame to clear the text area and send new keys.</li>
    * <li>The test interacts with the WYSIWIG editor and ensures that chagnes are reflected in the text area.</li>
    * </ol>
    */
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

    /** 
    * This method tests the interactions with a nested frames.
    * Process: 
    * <ol>
    * <li>To get the text, the test accesses top <html> frame inside the global <html>, and then accesses left <html> frame inside top <html> frame.</li>
    * <li>Similar steps to get the bottom <html> frame text. </li>
    * </ol>
    * 
    * It is important to enter and exit each frame to ensure test consistency and prevent errors. 
    */
    @Test
    public void testLeftAndBottomFrames(){
        var nestedFrames = homePage.clickNestedFrames();
        assertEquals(nestedFrames.getLeftFrameText(), "LEFT", "Incorrect frame text.");
        assertEquals(nestedFrames.getBottomFrameText(), "BOTTOM", "Incorrect frame text.");
    }

}
