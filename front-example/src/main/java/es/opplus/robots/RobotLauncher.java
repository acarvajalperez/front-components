package es.opplus.robots;

public class RobotLauncher {

    public RobotLauncher() {
        SeleniumUtils.setupChromeDriver();
        new Thread(new Robot1()).start();
    }
}
