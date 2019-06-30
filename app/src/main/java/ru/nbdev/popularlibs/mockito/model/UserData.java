package ru.nbdev.popularlibs.mockito.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    public UserData() {
    }

    public UserData(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Expose
    @SerializedName("avatar_url")
    public String avatarUrl;
}
