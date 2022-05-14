package enums;

public enum MainHeader {
COURSES("Курсы"),
    EVENTS("События"),
    CURATORS("Преподавателям"),
    COMPANIES("Компаниям"),
    ABOUTUS("О нас");

    private String translate;

    MainHeader(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}
