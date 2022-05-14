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

    @Key("testCourseName")
    TestCoursesNames testCourseName();

    @Key("testCourseLength")
    CoursesLength testCourseLength();

    @Key("testCourseDescr")
    CoursesDescr testCourseDescr();

    @Key("testEventsName")
    EventsNames testEventsName();

    @Key("eventsHeader")
    MainHeader eventsHeader();

}
