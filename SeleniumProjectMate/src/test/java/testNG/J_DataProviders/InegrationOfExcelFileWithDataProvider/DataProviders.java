package testNG.J_DataProviders.InegrationOfExcelFileWithDataProvider;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataProviders
{

    @DataProvider(name = "loginData",parallel = true)
    public static Object[][] excelDataProvider() throws IOException, InvalidFormatException {
        File file = new File("src/test/java/testNG/dataProviders/InegrationOfExcelFileWithDataProvider/OrangeHrmLoginData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int numberOfRows = sheet.getPhysicalNumberOfRows()-1;
        int noCells = sheet.getRow(0).getPhysicalNumberOfCells();

//        System.out.println("number of physical rows "+numberOfRows+"\n"+
//                "number of physical cells in a row "+noCells);


        Object[][] data = new Object[numberOfRows][noCells];


        for(int i=0; i<numberOfRows; i++)
        {

            for(int j=0; j<noCells; j++)
            {
                DataFormatter dataFormatter = new DataFormatter();
                data[i][j] = dataFormatter.formatCellValue(sheet.getRow(i+1).getCell(j));
            }

        }
        workbook.close();
        fis.close();

        return data;
    }
}
