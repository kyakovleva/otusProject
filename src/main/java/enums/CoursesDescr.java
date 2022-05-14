package enums;

public enum CoursesDescr {
    JAVAQADESCR("Автоматизация тестирования на Java с нуля", TestCoursesNames.JAVAQABASIC),
    QALEADDESCR("Best Practice по Soft и Hard Skills для эффективного управления командами тестирования", TestCoursesNames.QALEAD);

    private String description;
    private TestCoursesNames testCoursesNames;

    CoursesDescr(String description, TestCoursesNames testCoursesNames) {
        this.description = description;
        this.testCoursesNames = testCoursesNames;
    }

    public String getDescription() {
        return description;
    }

    public TestCoursesNames getCoursesNames() {
        return testCoursesNames;
    }
}
