package ru.nbdev.popularlibs.di.withDi;

import android.util.Log;

public class Red {
    private static final String TAG = "Red";

    public Red(Green green) {
        Log.d(TAG, green.show());
    }
}
