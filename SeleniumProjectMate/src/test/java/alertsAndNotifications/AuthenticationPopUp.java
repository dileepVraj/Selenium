package alertsAndNotifications;

import xpath.BaseClass;

public class AuthenticationPopUp extends BaseClass
{
    public static void main(String[] args) {

        browserInstantiation("chrome");
        /*This below url takes to webpage where authentication popup will be displayed where we have to pass
         * valid username and password to continue.*/
        //https://the-internet.herokuapp.com/basic_auth
        /*Actually we have three ways to handle these authentication popups.
         * 1. passing username and password in url.
         * 2. using auto it tools which automates windows applications using selenium.
         * 3. using Robot class in java.
         *
         * In this session we are going to know how to pass username and password to perform validation on
         * authentication popups using url approach.*/

        /*after https:// protocol and before starting url we have to pass username and password in this below format.
         *
         * https://username:password@URL*/
        StringBuilder userName = new StringBuilder("admin:");
        StringBuilder password = new StringBuilder("admin@");
        String url = "https://"+userName.append(password)+"the-internet.herokuapp.com/basic_auth";
        driver.get(url);
//        Alert authenticationPopUP = driver.switchTo().alert();
//        authenticationPopUP.accept();



    }
}
