package ru.nbdev.popularlibs.rx_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.reactivex.Observable;
import ru.nbdev.popularlibs.R;

/*
Активити состоит из двух кнопок. По нажатию на первую, начинает приходить сообщения.
По нажатию на вторую - отписка от сообщений. Реализовать с помощью RxJava
*/

public class RxJavaActivity extends AppCompatActivity {
    private Observable<String> publisher;
    private RxSubscriber subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        publisher = RxPublisher.getPublisher();
        subscriber = new RxSubscriber();
        buttonsInit();
    }

    private void buttonsInit() {
        findViewById(R.id.button_rx_java_subscribe)
                .setOnClickListener(v -> subscriber.subscribeTo(publisher));

        findViewById(R.id.button_rx_java_unsubscribe)
                .setOnClickListener(v -> subscriber.unsubscribe());
    }
}
