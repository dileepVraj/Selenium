package screenShots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import xpath.BaseClass;

import java.io.File;
import java.io.IOException;

public class CapturingScreenShotOfWebElement extends BaseClass
{
    public static void screenShotOfWebElement()
    {
        /*To take screenshot of particular webelement we have to call 'takeScreenShotAs' method on webelement that we
        * want to capture in screenshot and has to call implementations of OutPutType (FILE/BASE64/BYTES) on 'OutPutType' interface.
        *
        * */

        /*Sample code snippet with dummy webelement*/

        WebElement dummyElement = findElementById("Dummy");
        File dummyElementSc = dummyElement.getScreenshotAs(OutputType.FILE);
        try
        {
            FileHandler.copy(dummyElementSc,new File("./WebElementScreenShot/Dummy.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        /*Same as above we can also take screenshot of entire section by locating entire section in webpage and
        * storing that in webElement and calling 'getTakeScreenShotAs()' method on that and so on.*/
    }

    public static void main(String[] args)
    {
        browserInstantiation("chrome");

    }
}
