package helpers;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import sun.net.www.content.image.png;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by ArchanaDyavarintiBay on 25-07-2017.
 */
public class ScreenShot extends PageInstances {


    public ScreenShot(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static String getScreenShot() {


        String curDir = System.getProperty("user.dir");
        File file = new File(curDir + "\\target\\SavedFiles");
        if (!file.exists()) {
            file.mkdir();
        }
        UUID uuid = UUID.randomUUID();
        String fullPath = curDir + "\\target\\SavedFiles\\" + uuid.toString();
        fullPathToSavedFile = fullPath;


        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File(fullPath+".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fullPath;
    }

}
