package dropDowns.StaticDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import xpath.BaseClass;

public class HowToHandleStaticDropdown extends BaseClass
{
    /*we can select option of a static dropdown using selenium webdriver.
    *
    * Selenium can handle static dropdowns by using select class.
    *
    * A dropdown is identified by using select tagname and its options are represented with tagname option.*/

    /**To handle a dropdown we have to create an instance of Select class and have to pass webelement of dropdown to
     * constructor of Select class.
     *
     */

    /**
     * Example of html code to create a static dropdown:
     *
     *      <select>
     *         <option value="option1">Java</option>
     *         <option value="option2">Dot net</option>
     *         <option value="option3">Python</option>
     *         <option value="option4">Java script</option>
     *       </select>
     */

    /**
     * we can select options in dropdown by three methods in select class.
     * 1.SelectByVisibleText(String text);
     * 2.SelectByValue(String value);
     * 3.selectByIndex(int index); // zero based index.
     *
     */

    /** To get first selected option in static dropdown we have to use 'getFirstSelectedOption();' this method returns
     * webelement of option that selected first.
     *
     * Implementation of getFirstSelectedOption method in Select class.
     *      public WebElement getFirstSelectedOption()
     * {
     *         return (WebElement)this.getOptions().stream().filter(WebElement::isSelected).findFirst().orElseThrow(() ->
     *         {
     *             return new NoSuchElementException("No options are selected");
     *         });
     *
     */

    /** To get all options present in static dropdown we have to use 'getOptions' method of Select class.
     *
     * this method returns the List of webelements.
     *
     *implementation of 'getOptions' method.
     *
     * public List<WebElement> getOptions()
     * {
     *         return this.element.findElements(By.tagName("option"));
     * }
     */



    public static void main(String[] args)
    {
        WebElement element = driver.findElement(By.id("q"));
        Select select = new Select(element);
        select.isMultiple();
    }
}
