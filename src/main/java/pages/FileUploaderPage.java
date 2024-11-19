package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage {

    private WebDriver driver;
    private By chooseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uplodedFile = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

    public void uploadFile(String absolutePathOfFile){
        driver.findElement(chooseFileButton).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedMessage(){
        return driver.findElement(uplodedFile).getText();
    }

}
