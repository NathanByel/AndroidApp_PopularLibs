package ru.nbdev.popularlibs.di.dagger.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.nbdev.popularlibs.di.dagger.Green;

@Module
public class AppModule {

    @Provides
    @Singleton
    Green provideGreen() {
        return new Green();
    }
}
