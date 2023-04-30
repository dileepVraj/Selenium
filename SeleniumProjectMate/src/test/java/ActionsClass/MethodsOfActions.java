package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import xpath.BaseClass;

public class MethodsOfActions extends BaseClass
{
    /**
     * Actions class in Selenium provides a number of methods that are used to simulate complex user interactions.
     * Here are some of the commonly used methods in Actions class with examples:
     *
     */



    public static void moveToElement()
    {

        /**
         *
         * 1. moveToElement(WebElement element);
         *
         * This method moves the mouse to center of the webelement that passed as parameter.
         */

        driver.navigate().to("https://www.amazon.in/");
        WebElement mobiles =  findElementByXpath("//a[text()='Mobiles']");

        Actions actions = new Actions(driver);
        /**/
        actions.moveToElement(mobiles).perform();
        System.out.println("successfully performed");
        driver.quit();

    }

    /** 2.click();
     * This method clicks the left mouse button at the current mouse position.
     * Actions actions = new Actions(driver);
     * actions.click().build().perform();
     *
     */

    /**
     * 3.'doubleClick()' This method double, clicks the left mouse button at the current mouse position.
     * Actions actions = new Actions(driver);
     * actions.doubleClick(element).build().perform();
     *
     */

    /** 4.contextClick(webElement e)
     * This method performs a right-click on specified webelement.
     *
     *Code snippet:
     * Actions actions = new Actions(driver);
     * WebElement element = driver.findElement(By_id);
     * actions.contextClick(element).perform();
     */

    /**5.dragAndDrop(Webelement source, WebElement target);
     * This method performs a drag and drop operation from the source element to the target element.
     *
     * Code Snippet:
     * Actions actions = new Actions(driver);
     * WebElement sourceElement = driver.findElement(By_locator);
     * WebElement targetElement = driver.findElement(By_locator);
     * actions.dragAndDrop(source,target).perform();
     *
     */

    /**6.dragANdDropBy(WebElement source, int xOffset, int yOffset);
     * This method performs a drag and drop operation from the source element by specified x and y offset.
     *
     * Code Snippet:
     *      * Actions actions = new Actions(driver);
     *      * WebElement sourceElement = driver.findElement(By_locator);
     *      * actions.dragAndDropBy(source,50,100).perform();
     *
     */

    /*Note these keyUP and KeyDown methods are used to press keyboard keys, remember that to open a link in new tab
    * we have to press control key while clicking on the link specified.*/

    /** 7.keyDown(Keys key)
     * This method press and holds a specified keyboard key.
     *
     * Code Snippet:
     *      * Actions actions = new Actions(driver);
     *      * actions.keyDown(Keys.CONTROL).sendKeys("a").keysUP(Keys.CONTROL).build().perform();
     */

    /** 8. keyUP(Keys key);
     * This method releases a specified keyboard key.
     *
     * Code Snippet:
     *      *      * Actions actions = new Actions(driver);
     *      *      * actions.keyDown(Keys.CONTROL).sendKeys("a").keysUP(Keys.CONTROL).build().perform();
     */

    /** 10.pause(Duration duration);
     * This method waits for the specified amount of time before performing the next action.
     *
     * Code Snippet:
     *      * Actions actions = new Actions(driver);
     *      actions.pause(Duration.ofSeconds(2)).perform();
     */

    /**
     *
     * release();
     * This method releases the current mouse button that was pressed or held down.
     *
     * Code Snippet:
     *      * Actions actions = new Actions(driver);
     *      actions.clickAndHols(element).release().perform();
     */

    /** clickAndHold(webElement el);
     * This method perform click and hold operation on specified webelement.
     *
     * Code Snippet:
     * * Actions actions = new Actions(driver);
     * * actions.clickAndHold(element).perform();
     *
     */

    /**
     * moveByOffSet(int xOffset, int yOffset); This method moves the mouse cursor by a specified x and y offset from the
     * current position.
     *
     * Code Snippet:
     *      * Actions actions = new Actions(driver);
     *      actions.moveByOffset(50,100).perform();
     *
     *      Mouse will be moved from current position to the specified x and y offset position.
     *
     */

    public static void main(String[] args)
    {
        browserInstantiation("chrome");
        /*webElement of Mobiles option on amazon web application home screen.*/

        moveToElement();
        Actions actions = new Actions(driver);
        WebElement element = findElementById("hai");
        Point point = element.getLocation();
       int x =  point.getX();
       int y = point.getY();
        actions.dragAndDropBy(element,x,y);



    }
}
