package xpath.XpathAxes;

public class Ancestor
{
    /**
     * we cannot find single unique element by using ancestor xpath axes.
     *
     * we will find multiple elements that are ancestors to current element.
     *
     * To find all ancestor elements of a specific element we have to write syntax as follows.
     *
     * syntax: //tagName[condition]/ancestor::*
     *
     * The above syntax gives all ancestors of current element irrespective of tags.
     *
     * If we want to get ancestors of current element by specific tagName then we have to write syntax as follows.
     *
     * syntax: //currentElement/ancestor::specified tagName
     *
     * The above syntax gets all elements specified by tagName that are ancestors of reference(currentElement) element.
     */
}
