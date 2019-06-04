package ru.nbdev.popularlibs.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitApi {
    @GET("users/{user}")
    Call<UserData> loadUserData(@Path("user") String user);
}
