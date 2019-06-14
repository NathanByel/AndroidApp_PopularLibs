package ru.nbdev.popularlibs.mockito;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.nbdev.popularlibs.mockito.model.GitApi;

@Module
public class TestModule {

    @Provides
    @Singleton
    public GitApi provideGitApi() {
        return Mockito.mock(GitApi.class);
    }
}
