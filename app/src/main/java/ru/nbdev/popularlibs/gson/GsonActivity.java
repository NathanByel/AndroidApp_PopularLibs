package ru.nbdev.popularlibs.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nbdev.popularlibs.R;

public class GsonActivity extends AppCompatActivity {
    private static final String TAG = "GsonActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void onButtonClick() {
        String jsonText = "{\"time_of_year\": \"summer\", \"year\": 2019}";

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JsonData jsonData = gson.fromJson(jsonText, JsonData.class);

        Log.d(TAG, jsonData.toString());
    }
}
