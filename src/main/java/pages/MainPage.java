package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get(System.getProperty("base.url"));
    }

}
