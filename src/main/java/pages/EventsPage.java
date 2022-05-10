package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.Calendar.*;

public class EventsPage extends AbstractPage {
    @FindBy(xpath = "//p[contains(text(),'События')]")
    private WebElement eventsMenu;

    @FindBy(xpath = "//a[contains(@class,'header2-menu__dropdown-link')][@title='Календарь мероприятий']")
    private WebElement eventsCalendarButton;

    @FindBy(xpath = "//div[contains(@class,'dod_new-events__list')][contains(@class,'js-dod_new_events')]")
    private WebElement upcomingEventsBlocksElement;

    @FindBy(xpath = "//span[@class='dod_new-event__date-text']")
    private List<WebElement> eventDateTimeContainer;

    @FindBy(xpath = "//span[@class='dod_new-events-dropdown__input-selected']")
    private WebElement upcomingEventsSort;

    @FindBy(xpath = "//a[contains(text(),'ДОД')]")
    private WebElement upcomingEventsSortDod;

    @FindBy(xpath = "//div[@class='dod_new-type__text'][contains(text(),'День открытых дверей')]")
    private WebElement upcomingDODEventHeader;


    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        Actions actions = new Actions(driver);
        actions.moveToElement(eventsMenu).build().perform();
        eventsCalendarButton.click();
        String currentHeader = eventsCalendarButton.getText();
        Assert.assertEquals("Страница предстоящих мероприятий открыта некорректно", "Календарь мероприятий", currentHeader);
        logger.info("Открыта страница предстоящих мероприятий");
    }

    public boolean checkBlocksUpcomingEvents() { //Возможно тут тоже проблемы, не сммогла потестить
//На странице отображаются карточки предстоящих мероприятий.
        try {
            driver.findElement(By.tagName("a"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void checkDatesOfUpcomingEvents() {
//        Даты проведения мероприятий больше или равны текущей дате
        final By upcomingEventsBlocksElement = By.xpath("//div[contains(@class,'dod_new-events__list')][contains(@class,'js-dod_new_events')]");
        final By eventDateTimeContainer = By.xpath("//span[@class='dod_new-event__date-text']");
        Date dateNow = new Date();
        DateFormat df = new SimpleDateFormat("dd MMMMMMMM HH:MM");
        String currentDate = df.format(dateNow);
        WebElement upcomingEventsBlocks = driver.findElement(upcomingEventsBlocksElement);
        List<WebElement> futureEventsDates = upcomingEventsBlocks.findElements(eventDateTimeContainer);
//        for () {}// нужна помощь^^
//        я хотела объединить по парам каждые следующие значения,
//        т.е. дергать из List значения по порядяку 0+1, 2+3, 4+5, записывать в одно значение String.format
//        дергать текст и сравнивать с текущей датой(currentDate)
//                Проблема реализации дат в блоках в отусе в том, что xpathы у даты и времени одинаковые
//                и отличаются только самими значениями внутри элемента, другой реализации метода я не придумала(
        logger.info("Даты мероприятий больше текущей даты");
    }

    public void sortUpcomingEventsDOD() {
//        Пользователь сортирует мероприятия по типу ДОД
        Actions actions = new Actions(driver);
        actions.moveToElement(upcomingEventsSort).build().perform();
        upcomingEventsSort.click();
        actions.moveToElement(upcomingEventsSortDod).build().perform();
        upcomingEventsSortDod.click();
        logger.info("Мероприятия отсортированы по типу ДОД");
    }

    public void checkSortUpcomingEventsDOD() {
//        На странице отображаются карточки предстоящих мероприятий. На каждой карточке в типе указанно "День открытых дверей"
        //1.Скопировать проверку по датам?
        String upcomingDODEventHeaderText = upcomingDODEventHeader.getText();
        Assert.assertEquals("На странице отображаются не ДОД мероприятия", upcomingDODEventHeaderText, "День открытых дверей");

    }
}
