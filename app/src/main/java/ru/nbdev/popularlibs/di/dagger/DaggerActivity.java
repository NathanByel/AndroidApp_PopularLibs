package ru.nbdev.popularlibs.di.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.nbdev.popularlibs.R;

public class DaggerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        new Red();
        new White();
    }
}
