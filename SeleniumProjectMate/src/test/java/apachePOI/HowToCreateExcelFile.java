package apachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HowToCreateExcelFile
{


    public static void createExcelFile() throws IOException {
        /**
         * To create new workBook we have to create object of XSSFWorkBook class.
         */
        XSSFWorkbook workbook = new XSSFWorkbook();

        /**
         * To create sheet we have to call 'createSheet()' method on the XSSFWorkBook object.
         */

        XSSFSheet sheet = workbook.createSheet(); // this returns the XSSFSheet.
        // we have another overloaded 'createSheet' method where other one takes sheet name as argument.

        /**
         * To create a row inside a sheet we have to use 'createRow' on sheet variable and it takes an integer as parameter
         * which indicates the row number in the sheet.
         * Usually the indexes of rows or cells will start with 0.
         */

        XSSFRow row = sheet.createRow(0); // which returns the row.

        // Now we have created row now we have to get row from the sheet to add cells into the row.
        // we have to use 'createCell()' method on row after getting it to create cell in row.
        // This createCell method returns the cell.
        XSSFCell cell = sheet.getRow(0).createCell(0);
        // if we want to set the value to the cell we have to use the 'setCellValue' method where this method has
        // multiple overloaded methods.
        cell.setCellValue("Hello");
        XSSFCell cell1 = sheet.getRow(0).createCell(1);
        cell1.setCellValue("world");
        XSSFRow row1 = sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue("HYR");
        sheet.getRow(1).createCell(1).setCellValue("Tutorials");

        /**
         * Now we have to call 'write(FileInputStream)' method which writes all the data into the specified file in the
         * constructor.
         */
        //providing path to where to create the specified Excel file.
        File file = new File("C:\\Users\\dilee\\IdeaProjects\\SeleniumProjectMate\\src\\test\\java\\apachePOI.myExcel.xlsx");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        // writing data into the WorkBook.
        workbook.write(fileOutputStream);
        //closing workBook.
        workbook.close();

        /**
         * Point to be noted:
         *
         * if we use older or newer version of Excel work book classes and use opposite extension
         * to create the Excel file using path, then we cannot open that file, and it shows error 'cannot open this
         * file because format of file extension is nat valid'.
         */

    }

    public static void main(String[] args) throws IOException
    {
        createExcelFile();
    }
}
