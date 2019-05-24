package ru.nbdev.popularlibs.mvpnomoxy;

public interface MVP {
    interface View {
        String getText();

        void setResultText(String text);
    }

    interface Presenter {
        void onButtonOkClick();
    }
}
