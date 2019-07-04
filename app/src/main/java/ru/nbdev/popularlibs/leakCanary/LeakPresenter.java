package ru.nbdev.popularlibs.leakCanary;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.nbdev.popularlibs.R;

@InjectViewState
public class LeakPresenter extends MvpPresenter<LeakView> {
    private Context context;

    public LeakPresenter(Context context) {
        this.context = context;
    }

    public void func() {
        getViewState().show(context.getString(R.string.button));
    }
}
