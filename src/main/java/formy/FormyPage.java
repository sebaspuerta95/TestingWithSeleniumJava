package formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class FormyPage {

    private final WebDriver driver;
    private final By educationButton = By.id("radio-button-1");
    private final By sex = By.id("checkbox-3");
    private final By date = By.id("datepicker");
    private final By dropdown = By.id("select-menu");
    private final By submitButton = By.cssSelector("[role='button']");

    public FormyPage(WebDriver driver){
        this.driver=driver;
    }

    public void setInformation(String firstname, String lastname, String jobTitle){
        findElements("first-name").sendKeys(firstname);
        findElements("last-name").sendKeys(lastname);
        findElements("job-title").sendKeys(jobTitle);
    }

    public WebElement findElements(String locator){
        return driver.findElement(By.id(locator));
    }

    public void educationLevel(){
        driver.findElement(educationButton).click();
    }

    public void selectSex(){
        driver.findElement(sex).click();
    }

    private Select findDropdown(){
        return new Select(driver.findElement(dropdown));
    }

    public void chooseExperience (String option){
        findDropdown().selectByVisibleText(option);
    }

    public List<String> getMyOption (){
        List<WebElement> selectionList = findDropdown().getAllSelectedOptions();
        // Option 1: Stream().map()
        return selectionList.stream().map(e->e.getText()).collect(Collectors.toList());
        /*
        Option 2: Enhanced Loop
        List<String> selectionText = new ArrayList<>();
        for (WebElement element : selectionList){
            selectionText.add(element.getText());
        }
        return selectionText;
         */
    }

    public void datePicker(String myDate){
        driver.findElement(date).sendKeys(myDate);
    }

    public ThankPage clickSubmit(){
        driver.findElement(submitButton).click();
        return new ThankPage(driver);
    }

}
