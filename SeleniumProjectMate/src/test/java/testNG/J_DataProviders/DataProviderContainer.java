package testNG.J_DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviderContainer
{
    @DataProvider(name = "loginData1")
    public Object[][] loginData()
    {
        return new Object[][]
                {
                        {"Admin","admin123"},
                        {"Admin","admin1234"},
                        {"Admin123","admin123"}
                };
    }
}
