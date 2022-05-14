package pages;

import enums.EventsNames;
import enums.MainHeader;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.format.DateTimeFormatter;


import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;


public class EventsPage extends AbstractPage {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy").withLocale(new Locale("ru"));

    @FindBy(xpath = "//p[contains(text(),'События')]")
    private WebElement eventsMenu;

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
        MainHeader configEventButton = serverConfig.testEventsName1();
        EventsNames configEventName = serverConfig.testEventsName2();
        String findEventsButton = String.format("//p[contains(text(),'%s')]", configEventButton.getTranslate());
        String eventsCalendarButton = String.format("//a[contains(@class,'header2-menu__dropdown-link')][@title='%s']", configEventName.getTranslate());
        WebElement eventsButtonElement = driver.findElement(By.xpath(findEventsButton));
        WebElement eventsCalendarElement = driver.findElement(By.xpath(eventsCalendarButton));
        actions.moveToElement(eventsButtonElement).build().perform();
        eventsCalendarElement.click();
        String pageHeader = String.format("//div[contains(text(),'%s')]", configEventName.getTranslate());
        WebElement currentHeaderElement = driver.findElement(By.xpath(pageHeader));
        String getCurrentHeaderElementText = currentHeaderElement.getText();
        Assert.assertEquals("Страница предстоящих мероприятий открыта некорректно", configEventName.getTranslate(), getCurrentHeaderElementText);
        logger.info("Открыта страница предстоящих мероприятий");
    }

    public boolean checkBlocksUpcomingEvents() {
//На странице отображаются карточки предстоящих мероприятий.
        try {
            driver.findElement(By.tagName("a"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
//        logger.info("На странице отображаются карточки предстоящих мероприятий");
    }


    public void checkDatesOfUpcomingEvents() {
//        Даты проведения мероприятий больше или равны текущей дате
        By upcomingEventsBlocksPath = By.xpath("//div[contains(@class,'dod_new-events__list')][contains(@class,'js-dod_new_events')]");
        By eventContainerPath = By.xpath(".//a[@class='dod_new-event']");
        By eventNamePath = By.xpath(".//div[contains(@class,'js-dod-new-event-title')]");
        By eventDateTimeContainerPath = By.xpath(".//div[contains(@class,'dod_new-event__time')]");
        By eventDateTimeItemPath = By.xpath(".//span[contains(@class,'dod_new-event__time-item')]");
        By dateIconPath = By.xpath(".//span[contains(@class, 'dod_new-event__calendar-icon')]");
        By dateTextPath = By.xpath(".//span[contains(@class,'dod_new-event__date-text')]");

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.get(ChronoField.YEAR);

        WebElement upcomingEventsBlocks = driver.findElement(upcomingEventsBlocksPath);
        List<WebElement> eventContainers = upcomingEventsBlocks.findElements(eventContainerPath);

        eventContainers.forEach(event -> {
            WebElement eventDateTimeContainer = event.findElement(eventDateTimeContainerPath);
            WebElement eventName = event.findElement(eventNamePath);
            LocalDate eventDate = null;
            for (WebElement timeElement : eventDateTimeContainer.findElements(eventDateTimeItemPath)) {
                if (CollectionUtils.isNotEmpty(timeElement.findElements(dateIconPath))) {
                    String dateText = timeElement.findElement(dateTextPath).getText();
                    if (StringUtils.isNotEmpty(dateText)) {
                        eventDate = LocalDate.parse(dateText.toLowerCase() + " " + currentYear, dateFormatter);
                        break;
                    }
                }
            }
            if (eventDate == null) {
                logger.error("У курса с наименованием = \"{}\" не найдена дата", eventName.getText());
            } else if (eventDate.isAfter(currentDate) || eventDate.isEqual(currentDate)) {
                logger.info("У курса с наименованием = \"{}\" дата проведения корректна - {}", eventName.getText(), eventDate);
            } else {
                logger.error("У курса с наименованием = \"{}\" дата проведения некорректна - {}", eventName.getText(), eventDate);
            }

        });
        logger.info("Даты мероприятий больше текущей даты");
    }

    public void sortUpcomingEventsDOD() {
//        Пользователь сортирует мероприятия по типу ДОД
        Actions actions = new Actions(driver);
//        actions.moveToElement(upcomingEventsSort).build().perform();
        EventsNames configEventTypeName = serverConfig.testEventsName3();
        final By upcomingEventsSort = By.xpath("//span[@class='dod_new-events-dropdown__input-selected']");
        String findEventType = String.format("//a[contains(text(),'%s')]", configEventTypeName.getTranslate());
        WebElement currentCoursesBlock = driver.findElement(upcomingEventsSort);
        js.moveToElement(currentCoursesBlock);
        js.clickOnElement(currentCoursesBlock);
        WebElement findEventTypeElement = driver.findElement(By.xpath(findEventType));
        js.moveToElement(findEventTypeElement);
        js.clickOnElement(findEventTypeElement);
        logger.info("Мероприятия отсортированы по типу ДОД");
    }

    public void checkSortUpcomingEventsDOD() {
//        На странице отображаются карточки предстоящих мероприятий. На каждой карточке в типе указанно "День открытых дверей"
        //1.Скопировать проверку по датам?
        String upcomingDODEventHeaderText = upcomingDODEventHeader.getText();
        Assert.assertEquals("На странице отображаются не ДОД мероприятия", upcomingDODEventHeaderText, "День открытых дверей");
        logger.info("На странице отображаются карточки предстоящих мероприятий. На каждой карточке в типе указанно \"День открытых дверей\"");
    }
}
