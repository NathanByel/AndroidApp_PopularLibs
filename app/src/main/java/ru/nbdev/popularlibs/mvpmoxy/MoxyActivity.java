package ru.nbdev.popularlibs.mvpmoxy;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.nbdev.popularlibs.R;

public class MoxyActivity extends MvpAppCompatActivity implements MvpMoxyView {
    private EditText editText;
    private TextView textView;
    private Button buttonOk;

    @InjectPresenter
    MoxyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.moxy_title);

        findViews();
        setListeners();
    }

    private void findViews() {
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);
        buttonOk = findViewById(R.id.button_ok);
    }

    private void setListeners() {
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                presenter.onTextChanged(s.toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        buttonOk.setOnClickListener(v -> presenter.onButtonOkClick());
    }

    @Override
    public void setResultText(String text) {
        textView.setText(text);
    }
}
