package ru.nbdev.popularlibs.di.withoutDi;

import android.util.Log;

public class White {
    private static final String TAG = "White";

    public White() {
        Log.d(TAG, Green.getInstance().show());
    }
}
