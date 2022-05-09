import enums.WebDriverName;
import exceptions.DriverNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CoursePage;
import pages.MainPage;
import pages.TestCoursesPage;
import utils.DriverManager;

import java.util.List;

public class MainTest {

    private WebDriver driver;
    private static final WebDriverName webDriverName = WebDriverName.valueOf(System.getProperty("driverName")); //chrome

    @BeforeClass
    public static void startUpDriver() throws DriverNotFoundException {
        DriverManager.startUp(WebDriverName.valueOf(System.getProperty("driverName")));
    }

    @Before
    public void startInitBrowser() throws DriverNotFoundException {
        driver = DriverManager.initDriver(webDriverName, List.of(System.getProperty("browser.mode")));
    }

//    @After
    public void end() {
        DriverManager.end(driver);
    }

    @Test
    public void testCountCourses() {
        MainPage mainPage = new MainPage(driver);
        TestCoursesPage testCoursesPage = new TestCoursesPage(driver);
        CoursePage coursePage = new CoursePage(driver);
        mainPage.open();
        testCoursesPage.open();
        testCoursesPage.countCourses();
        coursePage.open();
    }
}
