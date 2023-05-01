package alertsAndNotifications;

import xpath.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class WebPushNotifications extends BaseClass
{
    /*Web push notifications/permission based popups are notifications that appear when a web page or web application
     *is loaded with two options allow and block.
     *
     * generally we have few multiple type of popups like, show notification, allow locations, allow to use mic and
     * allow to use camera.
     *
     * We have to handle these popups with different arguments passing addArgument to the method.
     *
     * To handle these type of push type notifications we have to use browserOptions class, in this file iam
     * using chrome driver so will use chromeOptions class.
     *
     * Create an instance of ChromeOptions class and perform sendArguments("disable-notifications");
     * on instance of chromeOptions and pass instance as argument to constructor of chromeDriver. */

    /*Practice websites:
    *
    *   👉 https://www.cleartrip.com/

        👉 https://web-push-book.gauntface.com/d...

        👉 https://whatmylocation.com/

        👉 https://mictests.com/

        👉 https://webcamtests.com/
        *
        * Teacher: https://www.youtube.com/watch?v=deKXbbIHD4w&ab_channel=HYRTutorials
*/

    public static void main(String[] args)
    {
        ChromeOptions options = new ChromeOptions();

        /*To handle other type of notifications like geolocation, mic and camera access notifications,
        * */
        HashMap<String,Object> contentSettings = new HashMap<>();
        HashMap<String,Object> profile = new HashMap<>();
        HashMap<String,Object> prefs = new HashMap<>();


        contentSettings.put("geolocation",1);// here we have to change key according to pop type we are going to handle
        // for notifications, we have to use "notifications" as key, for geolocation popups have to use "geolocation" key and
        // for media like microphone and camera we have to use "media_stream" as key.
        // to allow popup pass value 1, to block popup pass value 2, to ignore popup pass value 0.
        profile.put("managed_default_content_settings",contentSettings);// same for all types of popups.
        prefs.put("profile",profile);// same for all types of popups.
        options.setExperimentalOption("prefs",prefs);// same for all types of popups.


        WebDriverManager.chromedriver().setup();

//        options.addArguments("--disable-notifications");
        /*To disable notifications: use this value as parameter-> disable-notifications.
         * To disable permission popups we can use either -> disable-geolocation(esp for location popup).
         *disable-media-stream, we can use the preceding argument for all remaining popups like allow microphone access
         *and allow camera.
         *
         */
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.justdial.com/");


    }
}
