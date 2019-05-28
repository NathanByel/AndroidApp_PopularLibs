package ru.nbdev.popularlibs.observer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.nbdev.popularlibs.R;

/*
Создать активити. В активити 3 кнопки.
Одна кнопка называется “Подписаться”, вторая - “Отписаться”, треться - “Спам”.
Спам должен приходить (сообщения в лог) только, если вы на него подписались.
Спам присылается только по нажатию кнопки “Спам”. Использовать паттерн “Наблюдатель”.
При нажатии кнопки “Отписаться” спам должен перестать приходить (перестать приходить сообщения в лог).
Использовать паттерн “Наблюдатель”. Сообщения должны содержать имя потока. Выполнить без RxJava
*/

public class ObserverActivity extends AppCompatActivity {
    private MyPublisher publisher = new TestPublisher();
    private MySubscriber subscriber = new TestSubscriber();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        buttonsInit();
    }

    private void buttonsInit() {
        findViewById(R.id.button_observer_subscribe)
                .setOnClickListener(v -> publisher.subscribe(subscriber));

        findViewById(R.id.button_observer_unsubscribe)
                .setOnClickListener(v -> publisher.unsubscribe(subscriber));

        findViewById(R.id.button_observer_spam)
                .setOnClickListener(v -> publisher.notifySubscribers());
    }
}
