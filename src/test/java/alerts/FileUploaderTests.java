package alerts;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploaderTests extends BaseTestsTAU {

    @Test
    public void testUploadChromeDriver(){
        var fileUploader = homePage.clickFileUploader();
        fileUploader.uploadFile("C:\\Users\\USER\\Downloads\\Auto - Policy jacket.pdf");
        assertEquals(fileUploader.getUploadedMessage(), "Auto - Policy jacket.pdf", "Incorrect file uploaded.");
    }

}
