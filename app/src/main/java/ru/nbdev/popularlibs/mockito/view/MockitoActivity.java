package ru.nbdev.popularlibs.mockito.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nbdev.popularlibs.R;
import ru.nbdev.popularlibs.mockito.app.App;
import ru.nbdev.popularlibs.mockito.presenter.MockitoPresenter;

public class MockitoActivity extends AppCompatActivity implements MockitoView {

    @BindView(R.id.mockito_text)
    TextView textView;

    private MockitoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mockito);
        ButterKnife.bind(this);
        initPresenter();
    }

    private void initPresenter() {
        presenter = new MockitoPresenter();
        App.getAppComponent().inject(presenter);
        presenter.attachView(this);
    }

    @OnClick(R.id.mockito_button)
    void onButtonClick() {
        presenter.onButtonClick("JakeWharton");
    }

    @Override
    public void showUrl(String url) {
        textView.setText(url);
    }
}
