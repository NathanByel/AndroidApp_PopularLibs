package ru.nbdev.popularlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaButterKnifeSingleActivity extends AppCompatActivity {
    private static final String TAG = "subscriber";
    private Single<String> publisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_butter_knife_single);

        ButterKnife.bind(this);
        publisherCreate();
    }

    private void publisherCreate() {
        publisher = Single.create((SingleOnSubscribe<String>) emitter ->
            emitter.onSuccess("message")
        ).subscribeOn(Schedulers.io());
    }

    @OnClick(R.id.butter_knife_button_subscribe_single)
    void onSubscribeClick() {
        Disposable disposable = publisher.observeOn(AndroidSchedulers.mainThread()).subscribe(
                s -> Log.d(TAG, "onComplete: " + s),
                throwable -> Log.e(TAG, "onError: " + throwable));
    }
}
