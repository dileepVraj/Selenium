package miscellaneousTopics;

public class StaleElementReferenceException
{
    /*What is stale:
    * Stale means expired.
    * i.e, expired food, product etc..
    *
    * Why StaleElementReferenceException occurs:
    *
    * It occurs because one main reason.
    * 1.When a webpage refreshed after webdriver identified webelement.
    *
    * Explanation:
    *
    * Suppose we identified one webelement in DOM and, we are supposed to perform multiple operations on that webelement.
    * while performing series of operations on that webelement if webpage got refreshed then the corresponding id = a
    * unique series of numbers webdriver assigned to memorize that webelement from other webelements will be changed
    * once page got refreshed, so webdriver cannot find that webelement in that location we specified using locator.
    *
    * This can happen if webpage got refreshed or component of webpage got refreshed where webelement is located(AJAX comp).
    *
    * */

    /* https://www.lambdatest.com/blog/handling-stale-element-exceptions-in-selenium-java/

        visit the above link to get clear idea why staleElementException occurs and how to handle in three ways.
    */

}
