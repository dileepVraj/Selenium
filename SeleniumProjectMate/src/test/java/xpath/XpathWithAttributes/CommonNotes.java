package xpath.XpathWithAttributes;

public class CommonNotes
{
    /**
     * Writing xpath with attributes is a basic style of writing xpath than writing xpath using operators, conditions,
     * with index, functions, axes etc...
     *
     * We can say that writing xpath using attributes is a base before moving into writing all kind of writing xpath's.
     *
     *
     */

    /**
     * What are attributes?
     *
     * An attribute of a webelement is a characteristic or property that can be accessed or manipulated using selenium
     * webdriver.
     * some common attributes of webelements include:
     *
     * 1. id: A unique identifier for the element.
     * 2. class: The CSS class name(s) applied to the element.
     * 3. name: The name attribute of the element.
     * 4. text: The content of the element.
     * 5. value: The current value of the element(for input elements).
     * 6. href: The URL of the link(for anchor elements).
     * 7. type: The type attribute of the element(for input elements).
     * 8. disabled: a boolean indicating whether the element is disabled or not.
     * 9. selected: a boolean indicating whether the element is selected or not(for selected elements).
     * 10. size: the size of the element (for input elements).
     *
     * These attributes can be accessed using methods provided by the webElement interface, such as getAttribute(), getText(),
     * isEnabled(), isSelected(), and getSize();
     */

    /**
     * we know that if a webelement has id or name or a unique class name it is easy to identify that element using
     * anyone of them, if webelement doesn't have any of them but has some new attributes like style, decode etc...
     * we don't have any locators in selenium like style, decode, so we have to write xpath using these attributes to find
     * elements.
     */

    /**
     * generic syntax to find webelement using xpath with attribute:
     *
     *  syntax: //tagName[@attribute='value']
     */

    /**
     * understanding html syntax for a input text box:
     *
     * <input type="text" id="firstName" name="fName" class="name"/>
     * <input type="text" name="IName" class="name" value="abc"/>
     *
     * tag names in above two html elements:
     * 1. input.
     *
     * attribute names:
     * 1.type
     * 2.id
     * 3.name
     * 4.class
     *
     * attribute value:
     * 1.text.
     * 2.firstName.
     * 3.fName.
     * 4.name.
     * 5.IName.
     * 6.abc.
     */

    /**
     * We can't and don't have to use onClick and onMouseHover attributes of a webelement to locate it because they are
     * events in javaScript i.e these attributes purpose is to perform some action when click and mouseHover actions
     * are performed on certain webelements.
     */
}
