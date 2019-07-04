package ru.nbdev.popularlibs.leakCanary;

import com.arellomobile.mvp.MvpView;

public interface LeakView extends MvpView {
    void show(String text);
}
