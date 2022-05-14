package pages;

import enums.CoursesNames;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage extends AbstractPage {

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        //'Java QA Engineer. Basic'
        CoursesNames configCourseName = serverConfig.testCourseName1();
        String findCoursesBlock = String.format("//div[contains(text(),'%s')]", configCourseName.getTranslate());
//        String openedCoursesPageHeader = String.format("//div[@class='course-header2__title'][contains(text(), '%s')]",serverConfig.testCourseName1());

        WebElement currentCoursesBlock = driver.findElement(By.xpath(findCoursesBlock));
        js.moveToElement(currentCoursesBlock);
        js.clickOnElement(currentCoursesBlock);
//        String openedCurrentCoursesPageHeader = driver.findElement(By.xpath(openedCoursesPageHeader)).getText();
//
//        Assert.assertEquals(serverConfig.testCourseName1(),openedCurrentCoursesPageHeader);
        logger.info("Открыта страница курсов");
    }

    public void checkOpenedCoursesName() {
        //В карточке указана информация о курсе: Название, Описание, Длительность обучения

        String openedCoursesPageHeader = String.format("//div[@class='course-header2__title'][contains(text(), '%s')]", serverConfig.testCourseName1());
        String openedCurrentCoursesPageHeader = driver.findElement(By.xpath(openedCoursesPageHeader)).getText();
        Assert.assertEquals(serverConfig.testCourseName1(), openedCurrentCoursesPageHeader);
        logger.info("На странице отображается корректное название курсов");
    }

    public void checkOpenedCoursesLength() {
        //В карточке указана информация о курсе: Название, Описание, Длительность обучения
        String openedCoursesPageLength = String.format("//p[@class='course-header2-bottom__item-text'][contains(text(),'%s')]", serverConfig.testCourseLength1());
        String openedCurrentCoursesPageLength= driver.findElement(By.xpath(openedCoursesPageLength)).getText();
        Assert.assertEquals(serverConfig.testCourseLength1(), openedCurrentCoursesPageLength);
        logger.info("На странице отображается корректная продолжительность курсов");
    }
    public void checkOpenedCoursesDescr() {
        //В карточке указана информация о курсе: Название, Описание, Длительность обучения
        String openedCoursesPageDescr= String.format("//h1[@class='course-header2__subtitle'][contains(text(),'%s')]", serverConfig.testCourseDescr1());
        String openedCurrentCoursesPageDescr = driver.findElement(By.xpath(openedCoursesPageDescr)).getText();
        Assert.assertEquals(serverConfig.testCourseDescr1(), openedCurrentCoursesPageDescr);
        logger.info("На странице отображается корректное описание курсов");
    }

}
