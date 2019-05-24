package ru.nbdev.popularlibs.mvpnomoxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.nbdev.popularlibs.R;

public class NoMoxyActivity extends AppCompatActivity implements MVP.View {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.no_moxy_title);

        MVP.Presenter presenter = new Presenter(this);

        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);
        Button buttonOk = findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(v -> presenter.onButtonOkClick());
    }

    @Override
    public String getText() {
        return editText.getText().toString();
    }

    @Override
    public void setResultText(String text) {
        textView.setText(text);
    }
}
