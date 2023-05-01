package practice;

import org.openqa.selenium.Cookie;
import xpath.BaseClass;

import java.util.Set;

public class CookiesExample extends BaseClass
{
    public static void main(String[] args) {
        browserInstantiation("chrome");
        driver.get("https://google.com");
        Set<Cookie> cookies = driver.manage().getCookies();

        for(Cookie cookie:cookies)
        {

            if(cookie.getName().equals("OGPC"))
            {
                System.out.println(cookie);
            }
        }
        driver.quit();
    }
}
