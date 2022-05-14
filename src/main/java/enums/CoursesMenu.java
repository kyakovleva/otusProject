package enums;

public enum CoursesMenu {
    PROGRAMMING("Программирование"),
    QA("Тестирование"),
    ARCHITECTURE("Инфраструктура");

    private String translate;

    CoursesMenu(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}
