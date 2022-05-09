package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CoursePage extends AbstractMethods {

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        Actions actions = new Actions(driver);
        WebElement curCoursesBlock = driver.findElement(By.xpath("//div[contains(text(),'Java QA Engineer. Basic')]"));
        actions.moveToElement(curCoursesBlock);
        wait.waitUntilTextPresents(curCoursesBlock,"Java QA Engineer. Basic");
//        String coursesBlock = String.format("//div[contains(text(),'%s')]", serverConfig.testCourse1());
//        WebElement curCoursesBlock = driver.findElement(By.xpath(coursesBlock));
        curCoursesBlock.click();
        logger.info("Открыта страница курсов");
    }
}
