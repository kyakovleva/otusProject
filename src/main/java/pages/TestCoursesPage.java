package pages;

import enums.CoursesMenu;
import enums.MainHeader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TestCoursesPage extends AbstractPage {

    public TestCoursesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        Actions actions = new Actions(driver);
        MainHeader configCoursesButton = serverConfig.coursesHeader();
        CoursesMenu configCoursesListButton = serverConfig.coursesToTest();
        String findCoursesButton = String.format("//p[contains(text(),'%s')]", configCoursesButton.getTranslate());
        String testCoursesButton = String.format("//a[contains(@class,'header2-menu__dropdown-link')][@title='%s']", configCoursesListButton.getTranslate());
        WebElement findCoursesButtonElement = driver.findElement(By.xpath(findCoursesButton));
        WebElement testCoursesButtonElement = driver.findElement(By.xpath(testCoursesButton));
        actions.moveToElement(findCoursesButtonElement).build().perform();
        testCoursesButtonElement.click();
        String currentHeader = String.format("//h1[contains(text(),'%s')]", configCoursesListButton.getTranslate());
        WebElement currentHeaderElement = driver.findElement(By.xpath(currentHeader));
        String currentHeaderText = currentHeaderElement.getText();

        Assert.assertEquals("Страница открыта некорректно", configCoursesListButton.getTranslate(), currentHeaderText);
        logger.info("Открыта страница курсов =" + configCoursesButton.getTranslate());

    }

    public void countCourses() {
        WebElement coursesBlocks = driver.findElement(By.className("lessons"));
        List<WebElement> coursesBlocksList = coursesBlocks.findElements(By.tagName("a"));
        int countCoursesBlocks = coursesBlocksList.size();
        Assert.assertEquals("Количество курсов на странице не равно 11", 11, countCoursesBlocks);
        logger.info("Количество курсов на странице = 11");
    }

}
