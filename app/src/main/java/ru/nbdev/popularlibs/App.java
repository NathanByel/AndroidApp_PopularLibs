package ru.nbdev.popularlibs;

import android.app.Application;
import android.arch.persistence.room.Room;

import ru.nbdev.popularlibs.room.AppDatabase;

public class App extends Application {
    private static App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database").build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
