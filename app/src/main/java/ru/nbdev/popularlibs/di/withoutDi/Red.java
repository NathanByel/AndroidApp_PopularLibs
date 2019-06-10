package ru.nbdev.popularlibs.di.withoutDi;

import android.util.Log;

public class Red {
    private static final String TAG = "Red";

    public Red() {
        Log.d(TAG, Green.getInstance().show());
    }
}
