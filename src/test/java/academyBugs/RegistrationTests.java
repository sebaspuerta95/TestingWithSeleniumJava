package academyBugs;

import jdk.jfr.Name;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.nio.file.Paths;

/**
* This class was created to demonstrate how to use data-driven testing while submitting a registration form. 
* It is integrated with TestNG attributes to control de sources of information. 
*/ 
public class RegistrationTests extends BaseAB {

    // This class is an example of usage of soft assertions, aka validation testing.

    // Example importing the test data from a CSV file.
    @Test (priority = 1, dataProvider = "csvDataProvider", dataProviderClass = SupplierClass.class, groups = "academyBugs")
    public void testRegistrationWithCSV (String firstname, String lastname, String email, String retypeEmail,
                                  String password, String retypePassword,
                                  String expectedFirstnameMessage, String expectedLastnameMessage,
                                  String expectedEmailMessage, String expectedRetypeEmailMessage,
                                  String expectedPasswordMessage, String expectedRetypePasswordMessage) {

        regPage.inputValues(firstname, lastname, email, retypeEmail, password, retypePassword);
        regPage.clickRegisterButton();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(regPage.getFirstnameError(), expectedFirstnameMessage, "Incorrect firstname format");
        softAssert.assertEquals(regPage.getLastnameError(), expectedLastnameMessage, "Incorrect lastname format");
        softAssert.assertEquals(regPage.getEmailError(), expectedEmailMessage, "Incorrect email format");
        softAssert.assertEquals(regPage.getRetypeEmailError(), expectedRetypeEmailMessage, "Emails do not match");
        softAssert.assertEquals(regPage.getPasswordError(), expectedPasswordMessage, "The password format is incorrect");
        softAssert.assertEquals(regPage.getRetypePassError(), expectedRetypePasswordMessage, "Passwords do not match");

        softAssert.assertAll();
    }

    // Example using the test data from the IDE.
    @Test (priority = 2, dataProvider = "testDataSupplier", dataProviderClass = SupplierClass.class, groups = "academyBugs")
    public void testRegistrationWithTestDataInArray (String firstname, String lastname, String email, String retypeEmail,
                                         String password, String retypePassword,
                                         String expectedFirstnameMessage, String expectedLastnameMessage,
                                         String expectedEmailMessage, String expectedRetypeEmailMessage,
                                         String expectedPasswordMessage, String expectedRetypePasswordMessage) {

        regPage.inputValues(firstname, lastname, email, retypeEmail, password, retypePassword);
        regPage.clickRegisterButton();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(regPage.getFirstnameError(), expectedFirstnameMessage, "Incorrect firstname format");
        softAssert.assertEquals(regPage.getLastnameError(), expectedLastnameMessage, "Incorrect lastname format");
        softAssert.assertEquals(regPage.getEmailError(), expectedEmailMessage, "Incorrect email format");
        softAssert.assertEquals(regPage.getRetypeEmailError(), expectedRetypeEmailMessage, "Emails do not match");
        softAssert.assertEquals(regPage.getPasswordError(), expectedPasswordMessage, "The password format is incorrect");
        softAssert.assertEquals(regPage.getRetypePassError(), expectedRetypePasswordMessage, "Passwords do not match");

        softAssert.assertAll();
    }

}
