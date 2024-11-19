package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* This class models the context menu page that is tested in the { @DropdownTests } test class (src/test/dropdown). 
*/ 
public class DropdownPage {

    private WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage (WebDriver driver) {
        this.driver = driver;
    }

    /** This methods locates the dropdown element with the <select> HTML tag, and returns a Select object to interact with the options. 
    * The method returns a Select object, so we do not need to create a new object any time we interact with a dropdown. 
    * This method is private so it is not called from anywhere else.
    */ 
    private Select findDropdownElement(){
        return new Select(driver.findElement(dropdown));
    }

    /** 
    * Method used to select an option by visible text.
    * @param option : This is the visible text of the option that we are going to select. 
    */ 
    public void selectFromDropdown (String option) {
        findDropdownElement().selectByVisibleText(option);
    }

    /**
    * After the option is selected by visible text, this method retrieves all the selected options. 
    * This method is further used to test that only 1 option was selected. 
    * 
    * Process: 
    * <ol>
    *     <li>The driver locates the web element and stores all the selected options in a list of web elements.</li>
    *     <li>Then, we extract the text from the web elements and store it into a list of Strings.</li>
    * </ol>
    * @return List<String> : Returns a list of String of all the selected option. 
    */
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // This is a variation of the getSelectedOptions() method. It does the same, but uses an enhanced loop. 
    public List<String> loopVariation(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        List<String> elementsTexts = new ArrayList<>();
        for (WebElement element : selectedElements) {
            elementsTexts.add(element.getText());
        }
        return elementsTexts;
    }

    /**
     * This method changes the dropdown attribute and allows it to receive multiple options instead of only 1.
     * We cast the driver as a JavascritExecutor object to execute a JS script and change the <select> element attributes.
     */
    public void setMultipleAttribute(){
        String script = "arguments[0].setAttribute('multiple', '')";
        var jsExecutor = ((JavascriptExecutor)driver);
        // executeScript() takes 2 parameters: Javascript script, and the web element in which it is going to be applied.
        jsExecutor.executeScript(script, findDropdownElement());
    }

}
