package enums;

public enum TestCoursesNames {
    JAVAQABASIC("Java QA Engineer. Basic", CoursesLength.FOURMONTHS),
    QALEAD("QA Lead", CoursesLength.SIXMONTHS);

    private String translate;
    private CoursesLength coursesLength;

    TestCoursesNames(String translate, CoursesLength coursesLength ) {
        this.translate = translate;
        this.coursesLength = coursesLength;
    }

    public String getTranslate() {
        return translate;
    }

    public CoursesLength getCoursesLength() {
        return coursesLength;
    }
}
