package ru.nbdev.popularlibs;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
Создать активити. В активити 1 кнопка. Сделать с помощью AsyncTask.
При нажатии на кнопку приходит сообщение в лог, что метод, вызвавший AsyncTask, завершён.
Также приходит 5 сообщений в лог каждые 1 секунду. Сообщения должны содержать имя потока.
*/
public class AsyncTaskActivity extends AppCompatActivity {

    private static final String TAG = "AsyncTaskActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        Button button = findViewById(R.id.button_async_task);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyAsyncTask().execute();
            }
        });
    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 5; i++) {
                try {
                    Log.d(TAG, "doInBackground");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute");
        }
    }
}
