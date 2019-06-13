package ru.nbdev.popularlibs.di.dagger;

import android.util.Log;

import javax.inject.Inject;

import ru.nbdev.popularlibs.di.dagger.app.DaggerApp;

public class Red {
    private static final String TAG = "Red";

    @Inject
    Green green;

    public Red() {
        DaggerApp.getAppComponent().inject(this);

        Log.d(TAG, green.show());
    }
}
