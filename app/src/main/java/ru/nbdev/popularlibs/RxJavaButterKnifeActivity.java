package ru.nbdev.popularlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaButterKnifeActivity extends AppCompatActivity {
    private static final String TAG = "subscriber";
    private Observable<String> publisher;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_butter_knife);

        ButterKnife.bind(this);

        publisherCreate();
    }

    private void publisherCreate() {
        publisher = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                while (true) {
                    emitter.onNext("message");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).subscribeOn(Schedulers.io());
    }

    @OnClick(R.id.butter_knife_button_subscribe)
    void onSubscribeClick() {
        disposable = publisher.observeOn(AndroidSchedulers.mainThread()).subscribe(
                s -> Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s),
                throwable -> Log.e(TAG, "onError: " + throwable),
                () -> Log.d(TAG, "onComplete: "));
    }

    @OnClick(R.id.butter_knife_button_unsubscribe)
    void onUnsubscribeClick() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
