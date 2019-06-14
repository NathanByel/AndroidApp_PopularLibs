package ru.nbdev.popularlibs.mockito.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.nbdev.popularlibs.mockito.presenter.MockitoPresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MockitoPresenter mockitoPresenter);
}
