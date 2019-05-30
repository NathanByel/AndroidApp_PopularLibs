package ru.nbdev.popularlibs.rx_java;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RxSubscriber implements Observer<String> {
    private static final String TAG = "RxSubscriber";
    private Disposable disposable;

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");
        this.disposable = d;
    }

    @Override
    public void onNext(String s) {
        Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " + e);
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }

    public void subscribeTo(Observable<String> publisher) {
        publisher.observeOn(AndroidSchedulers.mainThread()).subscribe(this);
    }

    public void unsubscribe() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
