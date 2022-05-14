package enums;

public enum EventsNames {
    ALLEVENTS("Все мероприятия"),
    EVENTSCALENDAR("Календарь мероприятий"),
    COURSESSTARTSCALENDAR("Календарь запуска курсов"),
    INSTENSIVES("Интенсивы"),
    DODLONG("День открытых дверей"),
    DODSHORT("ДОД"),
    OPENVEBINAR("Открытый вебинар"),
    ONLINEMEETUP("Онлайн митап");


    private String translate;

    EventsNames(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}
