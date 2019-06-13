package ru.nbdev.popularlibs.di.dagger.app;

import android.app.Application;

public class DaggerApp extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = generateAppComponent();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent generateAppComponent() {
        return DaggerAppComponent
                .builder()
                //.appModule(new AppModule())
                .build();
    }
}
