package ru.nbdev.popularlibs.room;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.nbdev.popularlibs.App;
import ru.nbdev.popularlibs.R;

/*
    Создать RoomActivity. В активити можно добавлять User, добавлять несколько User, удалять User,
    обновлять User. У класса User поля id, name, surname, age.
*/
public class RoomActivity extends AppCompatActivity {
    private static final String TAG = "RoomActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_user)
    void onAddUserClick() {
        Disposable disposable = Single.create((SingleOnSubscribe<Long>) emitter -> {
            User user = new User("aaa", "aaa", 100);
            long i = App.getInstance().getDatabase().userDao().insert(user);
            emitter.onSuccess(i);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((aLong, throwable) -> {
                    Log.d(TAG, "Added user, ID = " + aLong);
                });
    }

    @OnClick(R.id.add_users)
    void onAddUsersClick() {
        Disposable disposable = Single.create((SingleOnSubscribe<List<Long>>) emitter -> {
            List<User> users = new ArrayList<>();
            users.add(new User("bbb", "bbb", 200));
            users.add(new User("ccc", "ccc", 200));

            List<Long> i = App.getInstance().getDatabase().userDao().insertList(users);
            emitter.onSuccess(i);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe((longs, throwable) -> {
                    Log.d(TAG, "Added users, ID = " + longs);
                });

    }

    @OnClick(R.id.delete_user)
    void onDeleteUserClick() {
        Disposable disposableGetAll = App.getInstance().getDatabase().userDao().getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {

                    Disposable disposable = Single.create((SingleOnSubscribe<Integer>) emitter -> {
                        int i = App.getInstance().getDatabase().userDao().delete(users.get(0));
                        emitter.onSuccess(i);
                    }).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread()).subscribe(integer -> {
                                Log.d(TAG, "Deleted user. " + integer);
                            }, throwable -> {
                                Log.d(TAG, "Delete error. " + throwable.toString());
                            });

                }, throwable -> {
                    Log.d(TAG, "Not found. " + throwable.toString());
                });
    }

    @OnClick(R.id.update_user)
    void onUpdateUserClick() {
        Disposable disposableGetAll = App.getInstance().getDatabase().userDao().getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    User user = users.get(0);
                    user.name = "aaaaaaaaaaaaa";
                    user.surname = "aaaaaaaaaaaaa";

                    Disposable disposable = Single.create((SingleOnSubscribe<Integer>) emitter -> {
                        int i = App.getInstance().getDatabase().userDao().update(users.get(0));
                        emitter.onSuccess(i);
                    }).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread()).subscribe(integer -> {
                                Log.d(TAG, "Updated user. " + integer);
                            }, throwable -> {
                                Log.d(TAG, "Update error. " + throwable.toString());
                            });

                }, throwable -> {
                    Log.d(TAG, "Not found. " + throwable.toString());
                });
    }
}
