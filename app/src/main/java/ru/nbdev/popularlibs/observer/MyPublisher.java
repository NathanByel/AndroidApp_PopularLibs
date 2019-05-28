package ru.nbdev.popularlibs.observer;

public interface MyPublisher {
    void subscribe(MySubscriber subscriber);

    void unsubscribe(MySubscriber subscriber);

    void notifySubscribers();
}
