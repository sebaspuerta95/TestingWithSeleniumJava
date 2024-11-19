package javascript;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JavascriptTests extends BaseTestsTAU {

    @Test
    public void testScrollIntoTable(){
        homePage.clickLargeAndDeepDOM().scrollToTable();
    }

    @Test
    public void testInfiniteScroll(){
        int index = 5;
        var infiniteScroll = homePage.clickInfiniteScroll();
        infiniteScroll.scrollToParagraph(index);
        assertEquals(infiniteScroll.getNumberOfParagraphsPresent(), index
                , "Incorrect number of paragraphs)");
    }

}
