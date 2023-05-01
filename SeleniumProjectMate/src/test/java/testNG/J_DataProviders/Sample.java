package testNG.J_DataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Sample
{
    @Test(dataProvider = "data")
    public void print(Object[] s)
    {
        System.out.println(Arrays.toString(s));
    }

    @Test(dataProvider = "collectionsData")
    public void printCollData(Object[] o)
    {
        System.out.println(Arrays.toString(o));
    }

    @DataProvider(name = "data")
    public Object[][] data()
    {
        return new Object[][]
                {
                        {"Id",001},
                        {"Roll-NUM",12}
                };
    }

    @DataProvider(name = "collectionsData")
    public Iterator<Object[]> collData()
    {
        List<Object> data = new ArrayList<Object>();
        data.add(new Object[]{"Dileep"});
        data.add(new Object[]{"Billionaire"});
        Iterator itr = data.iterator();

        return itr;
    }
}
