package academyBugs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    /*
     The objective of this code is to read each line from a CSV file, split it by commas, and
     add it to a list. The list is then converted to a 2D object array, which is compatible with
     TestNG's @DataProvider.
     */
    public static Object[][] readCSVData(String filePath){
        List<Object[]> records = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null){
                String [] values = line.split(",");
                records.add(values);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return records.toArray(new Object[0][0]);
    }

}
