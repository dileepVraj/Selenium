package testNG.I_Dependencies;

import org.testng.annotations.Test;

public class FedexShipment
{
    /**
     * Let's take a scenario that we have to place a shipment in FedEx.
     *
     * Steps:
     *
     * 1. create a shipment(tracking number is generated once shipment is placed).
     * 2. track the shipment(tracking number is required to track shipment).
     * 3. cancel the shipment(to cancel order we need tracking number).
     *
     * Now lets think:
     * If create shipment method is failed then tracking number will not be created and there is no chance that
     * track shipment and cancel shipment methods to pass.
     *
     * So we can say that shipment tracking and cancel shipment are dependent on success of create shipment method.
     */
    static String trackingID= null;
    @Test(priority = 1)
    public void createShipment()
    {
//        System.out.println(5/0);
        System.out.println("shipment created");
        trackingID = "FD20012HY2DEL";
    }

    @Test(priority = 0,dependsOnMethods = {"createShipment"})
    public void trackShipment() throws Exception {
        if(trackingID!=null)
        {
            System.out.println("tracking shipment, your shipment is in Bengaluru");
        }
        else
        {
            throw new Exception("invalid trackingID");
        }
    }

    @Test(priority = 2, dependsOnMethods = {"createShipment","trackShipment"})
    public void cancelShipment() throws Exception
    {
        if(trackingID!=null)
        {
            System.out.println("successfully canceled your shipment");
        }
        else
        {
           throw  new Exception("invalid trackingID");
        }
    }
}
