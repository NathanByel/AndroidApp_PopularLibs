package ru.nbdev.popularlibs.observer;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TestPublisher implements MyPublisher {
    private static final String TAG = "TestPublisher";
    private List<MySubscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(MySubscriber subscriber) {
        subscribers.add(subscriber);
        Log.d(TAG, "subscribeTo");
    }

    @Override
    public void unsubscribe(MySubscriber subscriber) {
        subscribers.remove(subscriber);
        Log.d(TAG, "unsubscribe");
    }

    @Override
    public void notifySubscribers() {
        for (MySubscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}
