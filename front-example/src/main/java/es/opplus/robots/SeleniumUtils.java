package es.opplus.robots;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class SeleniumUtils {

    public static void setupChromeDriver() {

        ClassLoader classLoader = RobotLauncher.class.getClassLoader();

        URL resource = classLoader.getResource("/chromedrivers/linux/chromedriver");
        File f = new File("driver");
        if (!f.exists()) {
            f.mkdirs();
        }

        File chromeDriver = new File("driver" + File.separator + "chromedriver");
        if (!chromeDriver.exists()) {
            try {
                chromeDriver.createNewFile();
                org.apache.commons.io.FileUtils.copyURLToFile(resource, chromeDriver);

                Set<PosixFilePermission> perms = new HashSet<>();
                perms.add(PosixFilePermission.OWNER_EXECUTE);
                perms.add(PosixFilePermission.GROUP_EXECUTE);
                perms.add(PosixFilePermission.OTHERS_EXECUTE);
                Files.setPosixFilePermissions(chromeDriver.toPath(), perms);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
    }

    /*
    // The ChromeDriver locations under the resource folder
    private static String MAC_DRIVER = "/chromedriver/mac/chromedriver";
    private static String LINUX_DRIVER = "/chromedriver/linux/chromedriver";
    private static String WINDOWS_DRIVER = "/chromedriver/windows/chromedriver.exe";

    public static void setupChromeDriver() {
        // OS type

        String osName = System.getProperty("os.name");

        if (osName.contains("Mac")) {
            File cDriver = new File(Robot1.class.getResource(MAC_DRIVER).getFile());

            // Is it executable
            if (!cDriver.canExecute()) {
                cDriver.setExecutable(true);
            }
            System.setProperty("webdriver.chrome.driver", Robot1.class.getResource(MAC_DRIVER).getFile());

            // Now checking for existence of Chrome executable.'
            if (!new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome").exists()) {
                throw new RuntimeException("");
            }
        } else if (osName.contains("Linux")) {

            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource("/chromedrivers/linux/chromedriver");

            System.setProperty("webdriver.chrome.driver", Robot1.class.getResource(LINUX_DRIVER).getFile());

            // Now checking for existence of Chrome executable.'
            if (!new File(System.getProperty("user.home") + "/usr/bin/google-chrome").exists()) {
                throw new RuntimeException("No se ha encontrado Chrome");
            }
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }
     */

}
