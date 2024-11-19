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

public class DropdownPage {

    private WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage (WebDriver driver) {
        this.driver = driver;
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(dropdown));
    }

    public void selectFromDropdown (String option) {
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> loopVariation(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        List<String> elementsTexts = new ArrayList<>();
        for (WebElement element : selectedElements) {
            elementsTexts.add(element.getText());
        }
        return elementsTexts;
    }

    // Javascript scripts.

    /**
     * This method changes the dropdown attribute and allows it to receive multiple choices
     * instead of only 1.
     */
    public void setMultipleAttribute(){
        String script = "arguments[0].setAttribute('multiple', '')";
        var jsExecutor = ((JavascriptExecutor)driver);
        jsExecutor.executeScript(script,findDropdownElement());
    }

}