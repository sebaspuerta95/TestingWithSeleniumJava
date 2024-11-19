package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
* This class models the file uploader page that is tested in the { @FileUploaderTests } test class (src/test/alerts). 
*/ 
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

    // A file's absolute path is required to be sent as keys to upload a file to the browser. It is easier than handling the file upload window.
    public void uploadFile(String absolutePathOfFile){
        driver.findElement(chooseFileButton).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedMessage(){
        return driver.findElement(uplodedFile).getText();
    }

}
