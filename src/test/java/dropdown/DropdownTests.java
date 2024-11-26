package dropdown;

import base.BaseTestsTAU;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
* This test class tests the usage of dropdown elements. It requires the Selenium Support dependency from Maven to be included to the pom.xml file. 
* It is related to {@link DropdownPage } at src/main/pages
*/ 
public class DropdownTests extends BaseTestsTAU {

    // Tests that only 1 option was selected and that it contains the expected text.
    @Test
    public void testSelectedOption(){
        var dropdownPage = homePage.clickDropdownMenu();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions1 = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions1.size(),1, "Incorrect number of selections");
        assertTrue(selectedOptions1.contains(option), "Option not selected");
    }

    // Changes the <select> HTML tag to allow multiple options and tests that all the options were added.
    @Test
    public void testSelectMultipleOptions(){
        var multipleDropdown = homePage.clickDropdownMenu();
        multipleDropdown.setMultipleAttribute();

        // A list with all the options is created, and then they are added to the options.
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
