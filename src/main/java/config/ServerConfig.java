package config;

import enums.CoursesDescr;
import enums.CoursesLength;
import enums.CoursesNames;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("courses")
    String courses();

    @Key("testCourseName1")
    CoursesNames testCourseName1();

    @Key("testCourseLength1")
    CoursesLength testCourseLength1();

    @Key("testCourseDescr1")
    CoursesDescr testCourseDescr1();
}
