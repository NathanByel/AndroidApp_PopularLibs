package ru.nbdev.popularlibs.mockito.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitApi {
    @GET("users/{user}")
    Observable<UserData> loadUserData(@Path("user") String user);
}
