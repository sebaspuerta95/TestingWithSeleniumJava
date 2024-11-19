package dropdown;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTestsTAU {

    @Test
    public void testSelectedOption(){
        var dropdownPage = homePage.clickDropdownMenu();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions1 = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions1.size(),1, "Incorrect number of selections");
        assertTrue(selectedOptions1.contains(option), "Option not selected");
    }

    @Test
    public void testSelectMultipleOptions(){
        var multipleDropdown = homePage.clickDropdownMenu();
        multipleDropdown.setMultipleAttribute();

        List<String> optionsSelected = Arrays.asList("Option 1", "Option 2");
        for (String option : optionsSelected){
            multipleDropdown.selectFromDropdown(option);
        }
        // Other option: optionsSelected.forEach(multipleDropdown::selectFromDropdown);

        var selectedOptions2 = multipleDropdown.getSelectedOptions();
        assertTrue(selectedOptions2.containsAll(optionsSelected), "All options were not selected.");
        assertEquals(selectedOptions2.size(), optionsSelected.size(), "Incorrect selection number.");
    }

}
