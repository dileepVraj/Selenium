package testNG.J_DataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class IndicesConceptSample
{
    @Test(dataProvider = "indices")
    public void print(String[] s)
    {
        System.out.println(Arrays.toString(s));
    }



    @DataProvider(name = "indices",indices = {0,2,4})// passing partial data using indices
    public Object[][] indicesDataProv()
    {
        return new Object[][]
                {
                        {"Dileep","raju"},
                        {"Khaisar","Jaha"},
                        {"Ram","raghu"},
                        {"Sita","Ram"},
                        {"Hello","World"}
                };


    }
}
