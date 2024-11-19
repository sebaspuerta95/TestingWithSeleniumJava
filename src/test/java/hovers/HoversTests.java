package hovers;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.*;

/**
* This test class was created to demonstrate the usage of the Actions class to hover over elements and interact with them. 
* This test class is related to {@link HoversPage} class that models the page with its fields and methods.
* It also uses dependency testing to showcase the usage of TestNG.
*/ 
public class HoversTests extends BaseTestsTAU {

    /**
    * Each of the following 3 test methods creates an instance of the HoversPage to validate the information that is displayed after hovering over an image. 
    * Process:
    * <ol>
    *   <li>Hover over a figure caption.</li>
    *   <li>Validate that the figure is displayed after we hover over it.</li>
    *   <li>Validate that the information that is displayed is the expected information.</li>
    * </ol>
    */ 
    @Test (groups = "hoverTests")
    public void testHoverUser1(){
        var hoversPage = homePage.clickHovers();
        var figureCaption = hoversPage.hoverOverImage(1);
        assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed.");
        assertEquals(figureCaption.getTitle(), "name: user1", "Incorrect title name.");
        assertEquals(figureCaption.getLinkText(),"View profile", "Incorrect link text.");
        assertTrue(figureCaption.getLink().endsWith("/users/1"), "Incorrect link.");
    }

    @Test (groups = "hoverTests", dependsOnMethods = "testHoverUser1")
    public void testHoverUser2(){
        var hoversPage = homePage.clickHovers();
        var figureCaption = hoversPage.hoverOverImage(2);
        assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed.");
        assertEquals(figureCaption.getTitle(), "name: user2", "Incorrect title name.");
        assertEquals(figureCaption.getLinkText(),"View profile", "Incorrect link text.");
        assertTrue(figureCaption.getLink().endsWith("/users/2"), "Incorrect link.");
    }

    @Test (groups = "hoverTests", dependsOnMethods = {"testHoverUser1", "testHoverUser2"})
    public void testHoverUser3(){
        var hoversPage = homePage.clickHovers();
        var figureCaption = hoversPage.hoverOverImage(3);
        assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed.");
        assertEquals(figureCaption.getTitle(), "name: user3", "Incorrect title name.");
        assertEquals(figureCaption.getLinkText(),"View profile", "Incorrect link text.");
        assertTrue(figureCaption.getLink().endsWith("/users/3"), "Incorrect link.");
    }

}
