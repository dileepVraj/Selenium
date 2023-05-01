package dropDowns.StaticDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import xpath.BaseClass;

public class MultiSelectDropDwns extends BaseClass
{
    /**
     * A multi select dropdown in HTML is a dropdown menu that allows the user to select multiple options at once.
     * Unlike a static dropdown, the options in multi-select dropdown can change based on user input or other external
     * factors.
     *
     * To create multi select dropdown in HTML, you would use the <select> tag with them "multiple" attribute.
     * Each option would be defined using the <option> tag as in a static dropdown.
     *
     * <select multiple>
     *               <option value="option1">Java</option>
     *               <option value="option2">Dot net</option>
     *               <option value="option3">Python</option>
     *               <option value="option4">Java script</option>
     *  </select>
     *
     *  In this example the "multiple" attribute in the <select> tag allows the user to select multiple options at once.
     *  the options themselves are defined using <option> tags, with the "value" attribute specifying the value that
     *  will be submitted to the server when the form containing the dropdown in submitted, and the text between the opening
     *  and closing <option> tags specifying the text that will be displayed to the user in the dropdown.
     *
     *  When the user selects multiple options from the dropdown, those options will be submitted to the server as an
     *  array by using the same name for the <select> element as you would for regular single select dropdown, and appending
     *  "[]" to the end of the name.
     *
     *  For example in PHP, you might access the values of a multi-select dropdown like this:
     *
     *  $selectedOptions = $_POST['myDropdownName[]'];
     */

    /** We can also find a dropdown is multiselect dropdown or not by using method on Select class named 'isMultiple'
     * where this method returns a boolean if the specified dropdown is multiple selected dropdown then it returns true
     * or returns false.
     *
     *like selectByIndex,selectByVisibleText,selectByValue we can also de select options from multiselect dropdown
     * using following methods.
     *
     * Note these methods can only applicable to multiselect dropdowns.
     *
     * deSelectByIndex();,deSelectByVisibleText();,deSelectByValue();getAllSelectedOptions();.
     */

    /** we can also deselect all options of multiselect dropdowns using deselectAll(); method.
     *
     *
     */

    public static void main(String[] args) {
        WebElement element = driver.findElement(By.id("q"));
        Select select = new Select(element);
        select.getAllSelectedOptions();

    }
}
