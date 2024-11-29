package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
* This class models the context menu page that is tested in the HoversTests test class (src/test/hovers). 
* It uses the Actions class to hover over a web element.
*/ 
public class HoversPage {

    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By figureCaption = By.className("figcaption");

    public HoversPage (WebDriver driver){
        this.driver = driver;
    }

    /**
    * This methods is used to hover over the specified web element in a list. 
    * @param index Starts at 1 and it represents the image in which we want to hover over.
    * @return FigureCaption : Returns a handle to the internal class FigureCaption that models the caption that is displayed when we hover over an element. 
    */
    public FigureCaption hoverOverImage(int index) {
        WebElement selectedElement = driver.findElements(figureBox).get(index-1);
        Actions actions = new Actions(driver);
        actions.moveToElement(selectedElement).perform();
        return new FigureCaption(selectedElement.findElement(figureCaption));
    }

    // Since hovering over an element does not take us to another page in this example, but displays a caption, we create an inner class to model it. 
    public class FigureCaption {

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption (WebElement caption){
            this.caption = caption;
        }

        /**
        * @return boolean : Returns true if the caption is displayed and false if it is not. 
        */
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        /**
        * @return String : Returns the title of the caption.
        */
        public String getTitle(){
            return caption.findElement(header).getText();
        }

        /**
        * @return String : Returns the link of the caption.
        */
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        /**
        * @return String : Returns the text of the caption.
        */
        public String getLinkText(){
            return caption.findElement(link).getText();
        }

    }

}
