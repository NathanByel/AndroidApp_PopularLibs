package ru.nbdev.popularlibs.leakCanary;

import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.nbdev.popularlibs.R;

public class LeakActivity extends MvpAppCompatActivity implements LeakView {
    private TextView textView;

    @InjectPresenter
    LeakPresenter presenter;

    @ProvidePresenter
    LeakPresenter providePresenter() {
        return new LeakPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);

        textView = findViewById(R.id.leak_text_view);
        findViewById(R.id.leak_button).setOnClickListener(v -> presenter.func());
    }

    @Override
    public void show(String text) {
        textView.setText(text);
    }
}
