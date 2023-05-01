package testNG.J_DataProviders.InegrationOfExcelFileWithDataProvider;

public class Introduction
{
    /**
     * Contents:
     * 1. What are libraries available to read data from Excel file?
     *
     * 2.Downloading and installation of apache POI Java library.
     *
     * 3.How to read data from Excel file dynamically?
     *
     * 4.How to create data provider by reading data from Excel file?
     *
     * 5.How to maintain the data provider in the separate class?
     */

    /**
     * Till, now we have specified data inside data provider method statically, which is not a good practice because
     * if we want to change the data in future we have to come to code level(data provider class) and have to change
     * the data which requires more effort.
     *
     * Our data provider should fetch data dynamically from some source and that data should feed to test method.
     *
     * Point to be Noted: in real time application testing, we never use static data inside the data provider method,
     * we should use a source and have to read data from that dynamically.
     *
     * The source can be XML, CSV, Json file (or) it can be Database.
     *
     * In this learning session we are going to learn how to integrate Excel files with data provider to fetch data
     * dynamically and supply it to the specified test method.
     *
     */

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * 1. What are libraries available to read data from Excel file?
     *
     * Before going into the topic let's understand what is Excel file, an Excel file is a spreadsheet file which has
     * rows and columns in it.
     * In Excel files we will store data in tabular format.
     *
     * Extensions used to create an Excel file:
     *
     * Suppose to create a Text file we use .txt extension and to create a xml file we use .xml, like that we have 2
     * extensions to create Excel files 1. xls 2. xlsx.
     * Where, as xlx is older version of Excel files and xlsx is for newer version of Excel files.
     *
     * There are two famous libraries available in Java to read and write data in Excel files.
     * 1. Apache POI.
     * 2. JExcelApi.
     */
    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * How to read data from Excel file?
     *
     * After adding Apache POI dependencies in maven project we have to create a class and any method with appropriate
     * name and we have to write the logic to read data from Excel workbook.
     *
     * we have to create File class instance and have to pass file path the which we want to read data, to the constructor
     * of the File class.
     *
     * Now we have to crate the instance of the FileInputStream class and pass file as argument to the constructor.
     *
     * Now this fileInputStream is reading the data in binary format now we have to read the data in Excel workbook format
     * so we have to create the instance of XSSFWorkBook or HSSFWorkBook and pass the fileInputStream object as
     * argument to the constructor of the workbook.
     *
     * no we have to get the sheet from the workbook using 'getSheetAt()' or 'getSheet()' method's and, we have to get
     * number of physical rows from the sheet and, number of physical cells in the row using and, write the loop condition
     * to read the data form the rows and columns dynamically and format the data type in the cell into string
     * using 'DataFormatter' class object.
     *
     * Syntax:
     *
     * DataFormatter df = new DataFormatter();
     * df.formatCellValue(sheet.getRow(i).getCell(j)); // which returns any type of data in string format.
     *
     *
     */

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * How to integrate data to data provider method?
     *
     *
     */
}

