package enums;

public enum CoursesLength {
    FOURMONTHS(4),
    SIXMONTHS(6);

    private int duration;

    CoursesLength(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getLengthMonth() {
        int lengthMonth = duration;

        if (lengthMonth == 1)
            return "месяц";
        else if (lengthMonth >= 2 && lengthMonth <= 5)
            return  "месяца";
        else
            return "месяцев";
    }
}
