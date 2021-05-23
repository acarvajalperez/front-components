package es.opplus.robots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class Robot1 implements Runnable {

    private static final String SEPARADOR = "|";
    private static WebDriver driver = null;

    @Override
    public void run() {
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("Resultado.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            driver.get("https://administracion.gob.es/pagFront/espanaAdmon/directorioOrganigramas/quienEsQuien/quienEsQuien.htm");
            //driver.manage().window().maximize();

            driver.findElement(By.cssSelector(".ppg-icon__search-w")).click();
            //wait.until(presenceOfElementLocated(By.cssSelector(".ppg-icon__search-w"))).click();
            //wait.until(presenceOfElementLocated(By.linkText("Ver Detalles"))).click();
            //wait.until(presenceOfElementLocated(By.linkText("Volver"))).click();

            //driver.findElement(By.linkText("Ver Detalles")).click();
            //driver.findElement(By.linkText("Volver")).click();

            try {
                WebElement element;
                for (int j = 1; j < 4260; j++) {
                    for (int i = 1; i < 10; i++) {
                        element = wait.until(presenceOfElementLocated(By.cssSelector(".o-list__item:nth-child(" + i + ") .o-list__name")));
                        fichero.write(element.getText().replace("\n", "").replace("\r", "") + SEPARADOR);
                        element = wait.until(presenceOfElementLocated(By.cssSelector(".o-list__item:nth-child(" + i + ") > .o-list--inline .ppg-table--type02 > li > .ppg-text")));
                        fichero.write(element.getText().replace("\n", ", ").replace("\r", "") + SEPARADOR);
                        element = wait.until(presenceOfElementLocated(By.cssSelector(".o-list__item:nth-child(" + i + ") .o-list__item:nth-child(2) .ppg-text:nth-child(1)")));
                        fichero.write(element.getText() + "\n");
                    }
                    wait.until(presenceOfElementLocated(By.xpath("//div[3]/button/span"))).click();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } finally {
            //driver.quit();
        }
    }
}
