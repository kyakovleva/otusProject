package utils;

import enums.WebDriverName;
import exceptions.DriverNotFoundException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class WebDriverFactory {

    public static WebDriver create(WebDriverName driverName, List<String> options) throws DriverNotFoundException {
        switch (driverName) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(options);
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(options);
                return new FirefoxDriver(firefoxOptions);
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(options);
                return new EdgeDriver(edgeOptions);
            default:
                throw new DriverNotFoundException(driverName);
        }
    }

    public static void initDriverManager(WebDriverName driverName) throws DriverNotFoundException {
        switch (driverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                break;
            default:
                throw new DriverNotFoundException(driverName);

        }
    }
}
