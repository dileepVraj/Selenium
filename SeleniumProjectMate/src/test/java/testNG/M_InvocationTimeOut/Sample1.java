package testNG.M_InvocationTimeOut;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import xpath.BaseClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample1 extends BaseClass
{
//    @Test(invocationCount = 5)
//    public void invocatinoSample()
//    {
//        String[] data = new String[6];
//        data[0] = "Dileep";
//        data[1] = "raju";
//        data[2] = "mutyala";
//        data[3] = "Yeditha";
//        data[4] = "savaram";
//        data[5] = "Kotthoru";
//
//        storeData(data);
//
//    }
//
//
//
//    public void storeData(Object[] data)
//    {
//        List<Object[]> data1 = new ArrayList<>();
//        data1.add(data);
//
//
//
//        for(Object[] array : data1)
//        {
//            System.out.println(Arrays.toString(array));
//        }
//
//    }

    @Test(invocationCount = 1)
    public void collectRandomUserData() throws InterruptedException {
        browserInstantiation("chrome");
        driver.get("https://randomuser.me");
        System.out.println( findElementByXpath("//li[@data-title='Hi, My name is']").getAttribute("data-value"));

    }
}
