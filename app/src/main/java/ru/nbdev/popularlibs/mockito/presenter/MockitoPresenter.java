package ru.nbdev.popularlibs.mockito.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.nbdev.popularlibs.mockito.model.GitApi;
import ru.nbdev.popularlibs.mockito.view.MockitoView;

public class MockitoPresenter {
    private static final String TAG = "MockitoPresenter";

    @Inject
    GitApi gitApi;

    private MockitoView view;

    public void onButtonClick(String name) {
        Disposable disposable = gitApi.loadUserData(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        userData -> view.showUrl(userData.avatarUrl),
                        throwable -> Log.d(TAG, throwable.toString())
                );
    }

    public void attachView(MockitoView mockitoView) {
        view = mockitoView;
    }
}
