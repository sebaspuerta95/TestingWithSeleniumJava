package javascript;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * As java does not support scrolls, we need to use Javascript to do this.
 * In this tests, we scroll into web elements that are already visible in the DOM and web elements that are not until we scroll into them. 
 * It is related to {@link pages.LargeAndDeepDOMPage} and {@link pages.InfiniteScrollPage} at src/main/pages
 */
public class JavascriptTests extends BaseTestsTAU {

    // This test scrolls into a web element that is always visible in the DOM. Its page is modeled in {@link pages.LargeAndDeepDOMPage}. 
    @Test
    public void testScrollIntoTable(){
        homePage.clickLargeAndDeepDOM().scrollToTable();
    }

    /** 
    * This test scrolls into a web element that becomes visible in the DOM only until we scroll into it. Its page is modeled in {@link pages.InfiniteScrollPage}. 
    * Process:
    * <ol>
    *   <li>Paraghraps are added as we scroll down, so the index indicates how many paragraphs we want to show up until we assert.</li>
    *   <li>An instance of the Infinite scroll page is created to scroll into the index.</li>
    *   <li>The test assets if the number of paragraphs equals the index, so we know we are at the desired place.</li>
    * </ol>
    */
    @Test
    public void testInfiniteScroll(){
        int index = 5;
        var infiniteScroll = homePage.clickInfiniteScroll();
        infiniteScroll.scrollToParagraph(index);
        assertEquals(infiniteScroll.getNumberOfParagraphsPresent(), index
                , "Incorrect number of paragraphs)");
    }

}
