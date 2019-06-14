package ru.nbdev.popularlibs.mockito;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import ru.nbdev.popularlibs.mockito.model.GitApi;
import ru.nbdev.popularlibs.mockito.model.UserData;
import ru.nbdev.popularlibs.mockito.presenter.MockitoPresenter;
import ru.nbdev.popularlibs.mockito.view.MockitoView;

@RunWith(MockitoJUnitRunner.class)
public class PresenterUnitTest {

    @Mock
    public MockitoView view;

    private MockitoPresenter presenter;

    public PresenterUnitTest() {
        System.out.println("run");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());

    }

    @Before
    public void before() {
        System.out.println("before");
        MockitoAnnotations.initMocks(PresenterUnitTest.class);
        presenter = Mockito.spy(new MockitoPresenter());

//        TestComponent component = DaggerTestComponent
//                .builder()
//                .testModule(new TestModule() {
//                    @Override
//                    public GitApi provideGitApi() {
//                        GitApi gitApi = super.provideGitApi();
//
//                        /*Mockito.when(gitApi.loadUserData(Mockito.any()))
//                                .thenAnswer(invocation -> {
//                                    String arg = invocation.getArgument(0);
//                                    switch (arg) {
//                                        case "JakeWharton":
//                                            return Observable.just(new UserData("http://JakeWharton"));
//                                        case "SomeUser":
//                                            return Observable.just(new UserData("http://SomeUser"));
//                                        case "IncorrectUser":
//                                            return Observable.just(new UserData("error"));
//                                        default:
//                                            return null;
//                                    }
//                                });*/
//
//                        Mockito.when(gitApi.loadUserData(Mockito.any()))
//                                .thenReturn(Observable.just(new UserData("http://JakeWharton")));
//
//                        return gitApi;
//                    }
//                })
//                .build();
//
//        component.inject(presenter);
//        presenter.attachView(view);
    }

    @Test
    public void test1() {
        System.out.println("test1");
        init();
        presenter.onButtonClick("JakeWharton");
        Mockito.verify(view).showUrl("http://JakeWharton");
    }

    @Test
    public void test2() {
        System.out.println("test2");
        init();
        presenter.onButtonClick("SomeUser");
        //Mockito.verify(view).showUrl("http://SomeUser");
        Mockito.verify(view).showUrl("http://JakeWharton");
    }

    @Test
    public void test3() {
        System.out.println("test3");
        init();
        presenter.onButtonClick("IncorrectUser");
        //Mockito.verify(view).showUrl("http://IncorrectUser");
        Mockito.verify(view).showUrl("http://JakeWharton");
    }

    private void init() {
        TestComponent component = DaggerTestComponent
                .builder()
                .testModule(new TestModule() {
                    @Override
                    public GitApi provideGitApi() {
                        GitApi gitApi = super.provideGitApi();

//                        Mockito.when(gitApi.loadUserData(Mockito.any()))
//                                .thenAnswer(invocation -> {
//                                    String arg = invocation.getArgument(0);
//                                    switch (arg) {
//                                        case "JakeWharton":
//                                            return Observable.just(new UserData("http://JakeWharton"));
//                                        case "SomeUser":
//                                            return Observable.just(new UserData("http://SomeUser"));
//                                        case "IncorrectUser":
//                                            return Observable.just(new UserData("error"));
//                                        default:
//                                            return null;
//                                    }
//                                });

                        Mockito.when(gitApi.loadUserData(Mockito.any()))
                                .thenReturn(Observable.just(new UserData("http://JakeWharton")));

                        return gitApi;
                    }
                })
                .build();

        component.inject(presenter);
        presenter.attachView(view);
    }
}
