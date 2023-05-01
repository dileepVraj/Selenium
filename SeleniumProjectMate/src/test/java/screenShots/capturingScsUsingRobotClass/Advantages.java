package screenShots.capturingScsUsingRobotClass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Advantages
{
    /**
     * Advantages using Robot class in java to capture screenshots are
     * 1. we can capture screenshots with including URL of webpage.
     * 2. Selenium cannot capture screenshots of Alerts that displayed on webpage.
     *
     * In second case while trying to capture screenshot wile alert is present in webpage we will get
     * 'UnHandledAlertException' because when there is an un handled alert present on webpage while webdriver script
     * is executing then the script won't be executed it will, abrupt by that particular alert so to overcome this
     * type of scenario we have to switch to the alert and handle alert either by using accept or dismiss method.
     *
     * we can capture screenshot of webpage that contains alert using Robot Class.
     *
     */


    public static void main(String[] args)
    {



    }
}
