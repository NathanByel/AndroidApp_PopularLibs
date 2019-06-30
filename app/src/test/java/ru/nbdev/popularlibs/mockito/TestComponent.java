package ru.nbdev.popularlibs.mockito;

import javax.inject.Singleton;

import dagger.Component;
import ru.nbdev.popularlibs.mockito.presenter.MockitoPresenter;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent {
    void inject(MockitoPresenter mockitoPresenter);
}
