package ru.nbdev.popularlibs.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {
    @Expose
    @SerializedName("avatar_url")
    public String avatarUrl;
}
