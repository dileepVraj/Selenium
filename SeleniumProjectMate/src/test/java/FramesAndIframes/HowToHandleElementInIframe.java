package FramesAndIframes;

public class HowToHandleElementInIframe
{
    /**
     * When working with elements inside an iframe, you need to first switch to the iframe context to access the elements
     * inside it.
     *
     * Here is how You can handle webelements inside an iframe using selenium webdriver in java:
     *
     * 1.Switch to the iframe context using the 'switchTo().frame()' method:
     * webelement iframe = driver.findElement(By.id("iframe_id"));
     * driver.switchTo().frame(iframe);
     *
     * 2.Once you are in the frame context, you can access its elements using regular webdriver commands:
     * WebElement element = driver.findElement(By.id("element_id");
     * element.sendKeys("text");
     *
     * 3.When you are finished working with elements inside iframe, you need to switch back to the default context using
     * the 'switchTo().defaultContent()' method.
     *
     * driver.switchTo().defaultContent();
     *
     * The above command will switch the webdriver context back to main page, allowing you to interact with elements
     * outside the iframe.
     *
     * Note:
     * When working with the iframes you need to be careful about which context you are in, as truing to access elements
     * outside the current context will result in a 'NoSuchElementException'.
     * Also be aware that some websites may use nested iframes, in which case you will need to switch to the correct
     * iframe context using the switchTo().frame() method multiple times.
     */
}
