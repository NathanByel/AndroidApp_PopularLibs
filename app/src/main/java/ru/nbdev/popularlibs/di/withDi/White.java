package ru.nbdev.popularlibs.di.withDi;

import android.util.Log;

public class White {
    private static final String TAG = "White";

    public White(Green green) {
        Log.d(TAG, green.show());
    }
}
