package config;

import enums.*;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("courses")
    String courses();

    @Key("testCourseName1")
    TestCoursesNames testCourseName1();

    @Key("testCourseLength1")
    CoursesLength testCourseLength1();

    @Key("testCourseDescr1")
    CoursesDescr testCourseDescr1();

    @Key("testEventsName2")
    EventsNames testEventsName2();

    @Key("testEventsName1")
    MainHeader testEventsName1();

    @Key("testEventsName3")
    EventsNames testEventsName3();
}
