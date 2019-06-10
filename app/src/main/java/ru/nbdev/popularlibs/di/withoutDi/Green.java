package ru.nbdev.popularlibs.di.withoutDi;

public class Green {
    private static final Green green = new Green();

    private Green() {
    }

    public static Green getInstance() {
        return green;
    }

    public String show() {
        return "green";
    }
}
