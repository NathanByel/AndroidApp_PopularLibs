package ru.nbdev.popularlibs.gson;

import com.google.gson.annotations.SerializedName;

public class JsonData {
    @SerializedName("time_of_year")
    public String timeOfYear;

    @SerializedName("year")
    public int year;

    @Override
    public String toString() {
        return "JsonData{" +
                "timeOfYear='" + timeOfYear + '\'' +
                ", year=" + year +
                '}';
    }
}
