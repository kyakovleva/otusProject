package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("courses")
    String courses();

    @Key("testCourse1")
    String testCourse1();
}
