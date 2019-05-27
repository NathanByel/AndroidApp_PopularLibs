package ru.nbdev.popularlibs.mvpnomoxy;

import ru.nbdev.popularlibs.Model;

public class Presenter implements MVP.Presenter {
    private Model model;
    private MVP.View view;

    public Presenter(MVP.View view) {
        model = new Model();
        this.view = view;
    }

    @Override
    public void onButtonOkClick() {
        String text = model.getTextData();
        text += view.getText();
        model.setTextData(text);
        view.setResultText(text);
    }
}
