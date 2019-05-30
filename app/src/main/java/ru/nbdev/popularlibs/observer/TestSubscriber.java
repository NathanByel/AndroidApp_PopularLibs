package ru.nbdev.popularlibs.observer;

import android.util.Log;

class TestSubscriber implements MySubscriber {
    private static final String TAG = "TestSubscriber";

    @Override
    public void update() {
        Log.d(TAG, "spam");
    }
}