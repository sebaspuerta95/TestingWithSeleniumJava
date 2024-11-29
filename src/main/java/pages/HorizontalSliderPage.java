package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
* This class models the horizontal slider page that is tested in the SliderTests test class (src/test/horizontalSlider). 
*/ 
public class HorizontalSliderPage {

    private WebDriver driver;
    private By sliderInput = By.tagName("input");
    private By rangeValue = By.id("range");


    public HorizontalSliderPage (WebDriver driver){
        this.driver=driver;
    }

    // This method is called to move the slider until the desired value. Keys are sent while the message doesn't match the desired value.
    public void moveSlider(String value){
        while (!getSliderValue().equals(value)){
            driver.findElement(sliderInput).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue(){
        return driver.findElement(rangeValue).getText();
    }

}
