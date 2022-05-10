package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestCoursesPage extends AbstractPage {
    @FindBy(xpath = "//p[contains(text(),'Курсы')]")
    private WebElement coursesMenu;

    @FindBy(xpath = "//a[contains(@class,'header2-menu__dropdown-link')][@title='Тестирование']")
    private WebElement testCoursesButton;

    @FindBy(xpath = "//h1[contains(text(),'Тестирование')]")
    private WebElement testHeader;

//    private final By coursesBlocks = By.xpath(".//div[@class='lessons']");

    public TestCoursesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        Actions actions = new Actions(driver);
        actions.moveToElement(coursesMenu).build().perform();
        testCoursesButton.click();
        String currentHeader = testHeader.getText();
//        String configHeader = String.format("//h1[contains(text(),'%s')]", ServerConfig.courses());
//        Assert.assertEquals("Страница открыта некорректно", serverConfig.courses(), currentHeader); //почему то не работает через серверконфиг проверка
        Assert.assertEquals("Страница открыта некорректно", "Тестирование", currentHeader);
        logger.info("Открыта страница курсов Тестирование");

    }

    public void countCourses() {
        WebElement coursesBlocks = driver.findElement(By.className("lessons"));
        List<WebElement> coursesBlocksList = coursesBlocks.findElements(By.tagName("a"));
        int countCoursesBlocks = coursesBlocksList.size();
        Assert.assertEquals("Количество курсов на странице не равно 11", 11, countCoursesBlocks);
        logger.info("Количество курсов на странице = 11");
    }

}
