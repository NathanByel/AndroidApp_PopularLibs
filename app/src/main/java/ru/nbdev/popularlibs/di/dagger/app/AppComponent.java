package ru.nbdev.popularlibs.di.dagger.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.nbdev.popularlibs.di.dagger.Red;
import ru.nbdev.popularlibs.di.dagger.White;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(Red red);

    void inject(White white);
}
