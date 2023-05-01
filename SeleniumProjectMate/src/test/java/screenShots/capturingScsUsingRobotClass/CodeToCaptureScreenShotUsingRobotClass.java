package screenShots.capturingScsUsingRobotClass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CodeToCaptureScreenShotUsingRobotClass
{
    public static void capturingScreenShotUsingRobotClass() throws AWTException, IOException

    {
        /**
         * This method is user defined method which captures screenshot of webpage with URL and it captures screenshot
         * even webpage has alert on it.
         *
         * This method contains multiple classes and objects of java classes which are unknown to dileep till now
         * i will explore my level best when possible to understand this whole syntax and methods and classes below.
         */
        Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage image = robot.createScreenCapture(rectangle);
        String destinationPath = System.getProperty("user.dir")+"//screenshots//robotScreenShot.png";
        ImageIO.write(image,"png",new File(destinationPath));

    }
}
