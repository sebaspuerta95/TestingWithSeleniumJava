package formyForm;

import base.BaseTestFormy;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FormTests extends BaseTestFormy {

    @Test
    public void testSuccessfulFormFill(){
        formyPage.setInformation("Sebastian", "Puerta", "QA");
        formyPage.educationLevel();
        formyPage.selectSex();
        formyPage.chooseExperience("2-4");
        List<String> selections = formyPage.getMyOption();
        assertEquals(selections.size(), 1, "Incorrect number of selections.");
        formyPage.datePicker("08/13/1995");
        var thankingPage = formyPage.clickSubmit();
        assertTrue(thankingPage.getSuccessAlert().contains("The form was successfully submitted!"),
                "Incorrect message.");
    }

}
