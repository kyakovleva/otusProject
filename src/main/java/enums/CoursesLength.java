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
}
