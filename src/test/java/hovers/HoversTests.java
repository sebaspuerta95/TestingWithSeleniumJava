package hovers;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoversTests extends BaseTestsTAU {

    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.clickHovers();
        var figureCaption = hoversPage.hoverOverImage(1);
        assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed.");
        assertEquals(figureCaption.getTitle(), "name: user1", "Incorrect title name.");
        assertEquals(figureCaption.getLinkText(),"View profile", "Incorrect link text.");
        assertTrue(figureCaption.getLink().endsWith("/users/1"), "Incorrect link.");
    }

    @Test
    public void testHoverUser2(){
        var hoversPage = homePage.clickHovers();
        var figureCaption = hoversPage.hoverOverImage(2);
        assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed.");
        assertEquals(figureCaption.getTitle(), "name: user2", "Incorrect title name.");
        assertEquals(figureCaption.getLinkText(),"View profile", "Incorrect link text.");
        assertTrue(figureCaption.getLink().endsWith("/users/2"), "Incorrect link.");
    }

    @Test
    public void testHoverUser3(){
        var hoversPage = homePage.clickHovers();
        var figureCaption = hoversPage.hoverOverImage(3);
        assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed.");
        assertEquals(figureCaption.getTitle(), "name: user3", "Incorrect title name.");
        assertEquals(figureCaption.getLinkText(),"View profile", "Incorrect link text.");
        assertTrue(figureCaption.getLink().endsWith("/users/3"), "Incorrect link.");
    }

}
