package config;

import enums.*;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("coursesHeader")
    MainHeader coursesHeader();

    @Key("coursesToTest")
    CoursesMenu coursesToTest();

    @Key("eventSortingTypeShort")
    EventsNames eventSortingTypeShort();

    @Key("eventSortingTypeLong")
    EventsNames eventSortingTypeLong();

    @Key("testCourseName1")
    TestCoursesNames testCourseName1();

    @Key("testCourseLength1")
    CoursesLength testCourseLength1();

    @Key("testCourseDescr1")
    CoursesDescr testCourseDescr1();

    @Key("testEventsName2")
    EventsNames testEventsName2();

    @Key("eventsHeader")
    MainHeader eventsHeader();

    @Key("testEventsName3")
    EventsNames testEventsName3();
}
