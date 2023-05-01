package cookies;

import org.openqa.selenium.Cookie;
import xpath.BaseClass;

import java.util.HashSet;
import java.util.Set;

public class CookieApiCommonMethods extends BaseClass
{
    /*
      Note: we have to use driver.manage() as prefix to all these methods.
    1.getCookies(); which returns all cookies of particular website or webpage, it returns all cookies in form of
    * java.util.set.
    *
    * 2.getCookieNamed(String NameOfCookie); it returns a cookie that have name as argument passed to this method.
      3.addCookie(Cookie cookie); adds specified cookie as argument.
      4.deleteCookie(Cookie cookie); delete specified cookie as argument.
      5.deleteCookieNamed(String, name); deletes a cookie with name passed as argument.
      6.deleteAllCookies(); deletes all cookies of particular website or page.
      */

    /*Sources:
    *
    * https://www.youtube.com/watch?v=h5G2XhduSVY
    *
    * the above link is to store and load cookies using file and file reader and some other classes.*/

    public static void main(String[] args) {
        browserInstantiation("chrome");
        driver.get("https://google.com");
        Cookie cookie = new Cookie("Personalized","009");// we have many overloaded constructors for cookie class which varies between
        // these properties. 1.String name, 2. String value, 3. String path, 4.String domain, 5.boolean isSecure
        //6.Date expiry, 7. boolean isHttpOnly.
        driver.manage().addCookie(cookie);

        for(Cookie c : getAllCookies())
        {
            System.out.println(c);
        }

        System.out.println(deleteAllCookies());

        if(getAllCookies().size()==0)
        {
            System.out.println("Out of stock");
        }
        else
        {
            for(Cookie c : getAllCookies())
            {

                System.out.println(c);
            }
        }
    }

    public static Set<Cookie> getAllCookies()
    {
        Set<Cookie> cookies =driver.manage().getCookies();
        return  cookies;
    }

    public static int deleteAllCookies()
    {
        driver.manage().deleteAllCookies();
        return driver.manage().getCookies().size();
    }


}
