package ru.nbdev.popularlibs.di.dagger;

import android.util.Log;

import javax.inject.Inject;

import ru.nbdev.popularlibs.di.dagger.app.DaggerApp;

public class White {
    private static final String TAG = "White";

    @Inject
    Green green;

    public White() {
        DaggerApp.getAppComponent().inject(this);

        Log.d(TAG, green.show());
    }
}
