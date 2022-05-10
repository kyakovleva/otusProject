package enums;

public enum CoursesDescr {
    JAVAQADESCR("Автоматизация тестирования на Java с нуля",CoursesNames.JAVAQABASIC),
    QALEADDESCR("Best Practice по Soft и Hard Skills для эффективного управления командами тестирования",CoursesNames.QALEAD);

    private String description;
    private CoursesNames coursesNames;

    CoursesDescr(String description,CoursesNames coursesNames) {
        this.description = description;
        this.coursesNames = coursesNames;
    }

    public String getDescription() {
        return description;
    }

    public CoursesNames getCoursesNames() {
        return coursesNames;
    }
}
