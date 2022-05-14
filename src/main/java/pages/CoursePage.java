package pages;

import enums.CoursesDescr;
import enums.CoursesLength;
import enums.TestCoursesNames;
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
        TestCoursesNames configCourseName = serverConfig.testCourseName1();
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
        TestCoursesNames configCourseName = serverConfig.testCourseName1();
        String openedCoursesPageHeader = String.format("//div[@class='course-header2__title'][contains(text(), '%s')]", configCourseName.getTranslate());
        String openedCurrentCoursesPageHeader = driver.findElement(By.xpath(openedCoursesPageHeader)).getText();
        Assert.assertEquals(configCourseName.getTranslate(), openedCurrentCoursesPageHeader);
        logger.info("На странице отображается корректное название курсов");
    }

    public void checkOpenedCoursesLength() {
        //В карточке указана информация о курсе: Название, Описание, Длительность обучения
        CoursesLength configCourseLength = serverConfig.testCourseLength1();
        String openedCoursesPageLength = String.format("//p[@class='course-header2-bottom__item-text'][contains(text(),'%s')]", configCourseLength.getDuration());
        String openedCurrentCoursesPageLength= driver.findElement(By.xpath(openedCoursesPageLength)).getText();
        Assert.assertEquals(configCourseLength.getDuration() +" "+ configCourseLength.getLengthMonth(), openedCurrentCoursesPageLength);
        logger.info("На странице отображается корректная продолжительность курсов");
    }



    public void checkOpenedCoursesDescr() {
        //В карточке указана информация о курсе: Название, Описание, Длительность обучения
        CoursesDescr configCourseDescr = serverConfig.testCourseDescr1();
        String openedCoursesPageDescr= String.format("//h1[@class='course-header2__subtitle'][contains(text(),'%s')]", configCourseDescr.getDescription());
        String openedCurrentCoursesPageDescr = driver.findElement(By.xpath(openedCoursesPageDescr)).getText();
        Assert.assertEquals(configCourseDescr.getDescription(), openedCurrentCoursesPageDescr);
        logger.info("На странице отображается корректное описание курсов");
    }

}
