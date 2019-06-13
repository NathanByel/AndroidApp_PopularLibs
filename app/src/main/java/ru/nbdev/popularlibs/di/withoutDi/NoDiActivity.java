package ru.nbdev.popularlibs.di.withoutDi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.nbdev.popularlibs.R;

public class NoDiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_di);

        Red red = new Red();
        White white = new White();
    }
}
