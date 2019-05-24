package ru.nbdev.popularlibs.mvpmoxy;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.nbdev.popularlibs.Model;

@InjectViewState
public class MoxyPresenter extends MvpPresenter<MvpMoxyView> {
    private Model model;
    private String viewText;

    public MoxyPresenter() {
        model = new Model();
        viewText = "";
    }

    public void onButtonOkClick() {
        String text = model.getTextData();
        text += viewText;
        model.setTextData(text);
        getViewState().setResultText(text);
    }

    public void onTextChanged(String text) {
        viewText = text;
    }
}
