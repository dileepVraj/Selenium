package synchronization;



import java.time.Duration;

import xpath.BaseClass;

public class ImplicitWaits extends BaseClass
{
	/*This implicitlyWait is an method in TimeOuts interface which is an nested interface in webdriver interface.
	 * 
	 *  This implicitlyWait is also called as global wait because it waits globally for all webElements at driver level.
	 *  
	 *  Signature:
	 *  default Timeouts implicitlyWait(Duration duration) 
	 *  	{
      			return implicitlyWait(duration.toMillis(), TimeUnit.MILLISECONDS);
    		}
    		It takes Duration class and its methods as argument.
    		
    		'Advantages': this wait mechanism waits for all webElements until the specified time completes.
    		
    		'Disadvantages': if any webElement in the script is not valid webdriver will waits until specified time in implicitlyWait completes
    		and don't throw any Exception.
	 *  
	 * */
	
	public static void main(String[] args)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
