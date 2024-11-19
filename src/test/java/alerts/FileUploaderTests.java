package alerts;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import pages.FileUploaderPage;

import static org.testng.Assert.assertEquals;

/**
* This test class is meant to test that a file is uploaded successfully from our computer.  
* It is related to {@link FileUploaderPage } class (src/main/pages).
*/ 
public class FileUploaderTests extends BaseTestsTAU {

    /** We do not need to interact with the file uploading window, we just need to send the file's absolute path as a String using sendKeys() method. 
    * The test then validates that the correct file name was uploaded. 
    */
    @Test
    public void testUploadChromeDriver(){
        var fileUploader = homePage.clickFileUploader();
        fileUploader.uploadFile("C:\\Users\\USER\\Downloads\\Auto - Policy jacket.pdf");
        assertEquals(fileUploader.getUploadedMessage(), "Auto - Policy jacket.pdf", "Incorrect file uploaded.");
    }

}
