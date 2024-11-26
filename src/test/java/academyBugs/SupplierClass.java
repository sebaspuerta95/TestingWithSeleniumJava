package academyBugs;

import org.testng.annotations.DataProvider;
import java.nio.file.Paths;

public class SupplierClass {

    // This method is using the path of the CSV to read the data and supply it to the test method.
    @DataProvider(name = "csvDataProvider")
    public Object[][] csvDataProvider (){
        String path = Paths.get("resources/testdate.csv").toString();
        return CSVUtils.readCSVData(path);
    }

    // This method uses the test data directly from the code editor.
    @DataProvider(name = "testDataSupplier")
    public Object[][] testDataSupplier(){
        return new Object[][] {
                // Test case 1: All fields correct
                {
                        "Sebas", "Puerta", "sebas@gmail.com", "sebas@gmail.com", "sebas1", "sebas1",
                        "", "", "", "", "", "", true
                },
                // Test case 2: Missing email and retype email
                {
                        "Sebas", "Puerta", "", "", "sebas1", "sebas1",
                        "", "", "Please enter a valid Email", "", "", "", false
                },
                // Test case 3: Passwords do not match
                {
                        "Sebas", "Puerta", "sebas@gmail.com", "sebas@gmail.com", "sebas1", "sebas2",
                        "", "", "", "", "", "Your passwords do not match", false
                },
                // Test case 4: Empty first name, last name, invalid email format, mismatched email and password issues
                {
                        "", "", "1", "", "1", "1",
                        "Please enter your First Name", "Please enter your Last Name", "Please enter a valid Email",
                        "Your email addresses do not match", "Please enter a password of at least 6 characters", "", false
                },
                // Test case 5: Invalid email format, password too short
                {
                        "Sebas", "Puerta", "sebasgmail.com", "sebasgmail.com", "sebas1", "sebas1",
                        "", "", "Please enter a valid Email", "", "", "", false
                }
        };
    }

}
