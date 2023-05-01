package testNG.P_Reports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class F_LogDifferentTypesOfInformation
{
    /**
     * In this class we are going to learn how to log different types of information into extent reports,as we saw what are
     * different types of logs present in extent reports.
     *
     * We are going to log different types of information in realtime project like follow:
     *
     * 1.Text- Bold, Italic.
     * 2. XML.
     * 3. JSON.
     * 4. Collection Data (List,Set and Map)
     * 5. Highlight any message.
     * 6. Exception.
     * * */

    /**
     * In this session we are going to create one separate test method to log each different type of information.
     */

    @Test
    public void logDifferentInfo()
    {
        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(new File("ReportFiles/LogDifferentTypesOfInfo/DifferentInfo.html"));
        engine.attachReporter(spark);

        engine.createTest("DifferentTypesOfInformation")
                //logging normal plane text using 'INFO' log.
                .log(Status.INFO,"Normal plane text")
                /*Logging Bold type text using 'INFO' tag, to log bold type text we have to use the <b> as prefix and
                * </b> as suffix for the text we are logging, this technique is adopted from html documents.*/
                .log(Status.INFO,"<b>Bold Text</b>")
                // logging italic type text using 'INFO' log.
                .log(Status.INFO,"<i>Italic Text</i>")
                //logging text with italic and bold style to 'INFO' log.
                .log(Status.INFO,"<i><b>Italic and bold Text</i></b>");
                engine.flush();

       try
       {
           // to open report automatically after test method execution completes successfully.
           Desktop.getDesktop().browse(new File("ReportFiles/LogDifferentTypesOfInfo/DifferentInfo.html").toURI());
       }
       catch(IOException e)
       {
           e.printStackTrace();
       }

        /**
         * Apart from these we do have other text formats in text, that we can apply and use them in log's, we can see them
         * in html styles in w3c schools website.
         */




    }

    @Test
    public void logXmlData()
    {
        // visit https://json.org/example.html this application for sample xml and Json data.

        // storing data in string type variable.

        String xmlData = "<menu id=\"file\" value=\"File\">\n" +
                "  <popup>\n" +
                "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
                "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
                "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
                "  </popup>\n" +
                "</menu>";

        /*We cannot log the xml data in form of text, we have to use 'log(Status,<Markup)' method to log the xml data
        into the extent reports.*/

        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ReportFiles/LogDifferentTypesOfInfo/XmlInfo.html");
        engine.attachReporter(spark);

        engine.createTest("Xml Data logging")
                .log(Status.INFO, MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
        engine.flush();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/LogDifferentTypesOfInfo/XmlInfo.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void logJsonData()
    {
        // visit https://json.org/example.html this application for sample xml and Json data.

        //Storing Json data in string variable.
        String jsonData = "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";
        /*We cannot log the Json data in form of text, we have to use 'log(Status,Markup)' method to log the Json data
        into the extent reports.*/

        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ReportFiles/LogDifferentTypesOfInfo/JsonInfo.html");
        engine.attachReporter(spark);

        engine.createTest("Json Data logging")
                .log(Status.INFO,MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));
        engine.flush();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/LogDifferentTypesOfInfo/JsonInfo.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }


    @Test
    public void logListTypeData()
    {
        /**
         * In this method we are going to log collection type data like set, list, map into extent reports.
         */

        /**
         * For logging collection type data we have to use 'MarkupHelper' class
         */

        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ReportFiles/LogDifferentTypesOfInfo/ListTypeData.html");
        engine.attachReporter(spark);

        List listData = new ArrayList();
        listData.add("Elon-Musk");
        listData.add("Bill-gates");


        engine.createTest("List type data")
                .log(Status.INFO,MarkupHelper.createOrderedList(listData));
        engine.flush();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/LogDifferentTypesOfInfo/ListTypeData.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void logSetTypeOfData()
    {
        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ReportFiles/LogDifferentTypesOfInfo/SetTypeData.html");
        engine.attachReporter(spark);

        Set SetData = new HashSet();
        SetData.add("Elon-Musk");
        SetData.add("Bill-gates");


        engine.createTest("Set type data")
                .log(Status.INFO,MarkupHelper.createUnorderedList(SetData));
        engine.flush();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/LogDifferentTypesOfInfo/SetTypeData.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void logMapTypeData()
    {
        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ReportFiles/LogDifferentTypesOfInfo/MapTypeData.html");
        engine.attachReporter(spark);

        Map MapData = new HashMap();
        MapData.put("Name","Dileep");
        MapData.put("Gender","Male");


        engine.createTest("Set type data")
                .log(Status.INFO,MarkupHelper.createUnorderedList(MapData));
        engine.flush();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/LogDifferentTypesOfInfo/MapTypeData.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void highlightLogMessage()
    {
        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ReportFiles/LogDifferentTypesOfInfo/MapTypeData.html");
        engine.attachReporter(spark);




        engine.createTest("Highlight log message")
                .log(Status.INFO,MarkupHelper.createLabel("HelloWorldMessage", ExtentColor.BLUE));
        engine.flush();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/LogDifferentTypesOfInfo/MapTypeData.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void logExceptions()
    {
        /**
         * The super class of all exceptions is throwable class, we can create instance of throwable class or, we can
         * create an exception.
         *
         */

        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(new File("ReportFiles/LogDifferentTypesOfInfo/Exceptions.html"));
        engine.attachReporter(spark);

        try
        {
            System.out.println(5/0);
        }
        catch(ArithmeticException e)
        {
           engine.createTest("Exceptions logging")
                   .log(Status.INFO,e);
        }

        Throwable t = new RuntimeException("This is runtime exception");
        engine.createTest("Customized exception logging")
                .log(Status.INFO,t);
        engine.flush();

    }


}
