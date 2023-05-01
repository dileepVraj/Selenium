package apachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HowToReadDataFromExcel
{
  static  String excelFilePath = "C:\\Users\\dilee\\IdeaProjects\\SeleniumProjectMate\\src\\test\\java\\apachePOI.myExcel.xlsx";

    /**
     * In this class we will learn first how to read data from Excel file.
     *
     * How to read different types of data?
     *
     * 1. reading numeric data.
     * 2. reading boolean data.
     * 3. read data from multiple rows and multiple cells.
     *
     *
     */

    public static void readDataFromExcel() throws IOException {
        // Creating file instance using File class and passing location of file to the constructor.
        File file = new File(excelFilePath);
        // create FileInputStream instance and pass file to the constructor, this FileInputStream reads data from the file.
        FileInputStream fileInputStream = new FileInputStream(file);
        // this FileInputStream reads the Excel data in bytes format, so assume that we have raw data in this instance.
        // Now we need to convert that raw data into workbook format using XSSFWorkBook or HSSFWorkBook classes.

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        // now from the work book we need to get the sheet and then row and then cell.
        // to get the sheet from workbook we have 2 overloaded methods 1. getSheet(); 2. getSheetAt();
        // this getSheet() method gets sheet based on sheet name, and getSheetAt() gets sheet using index.
        XSSFSheet sheet = workbook.getSheetAt(0);
        // get row from sheet.
        XSSFRow row = sheet.getRow(0);
        // get cell from the row.
        XSSFCell cell = row.getCell(0);
        // get the data from the cell using 'getStringCellValue()' on cell.
        String cellData = cell.getStringCellValue();// return the data in the cell in string format.
        // printing the data.
        System.out.println(cellData);
        // closing the workbook.
        workbook.close();
        // closing the inputStream.
        fileInputStream.close();

    }



    public static void readExcelFileDynamically() throws IOException {
        /**
         * Now assume we have a Excel file in real time, and we don't know how-many rows and columns we have in that file.
         * Our test script should automatically identify how many number of rows and columns are in a sheet, and we have
         * to read that data from them.
         * And another point to catch is that in real time we don't know that which cell contains which type of cell value
         * in it.
         */

        /**
         * To get the row's in Excel file which has data in it, we have a method 'getPhysicalNumberOfRows()'
         */

        String testData = "C:\\Users\\dilee\\OneDrive\\Documents\\TestData.xlsx";
        File file = new File(testData);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // getting number of physical rows from sheet.
        int noPhysicalRows = sheet.getPhysicalNumberOfRows();
        // now we got total number of rows with data in sheet, so we can find out how many cells are present in each
        // row.

        for(int i=0; i<noPhysicalRows; i++)
        {
            XSSFRow row = sheet.getRow(i);
            int cellCount = row.getPhysicalNumberOfCells();

            for(int j=0; j<cellCount; j++)
            {
                XSSFCell cell = row.getCell(j);
                String cellValue = getCellValue(cell);
                System.out.print(cellValue+"  ");
            }
            System.out.println();
        }

    }


    public static String getCellValue(XSSFCell cell)
    {
        switch(cell.getCellType())
        {
            /*This 'getCellType' method tells us which type of data is present in the cell like , numeric, boolean,
             * string,blank,error,date type etc...*/

            case NUMERIC:
                return String.valueOf((int)cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return cell.getStringCellValue();
        }

    }

    public static void main(String[] args) throws IOException
    {

//        readDataFromExcel();
        readExcelFileDynamically();
    }

}
