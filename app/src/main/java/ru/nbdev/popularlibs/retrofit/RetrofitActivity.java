package ru.nbdev.popularlibs.retrofit;

import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nbdev.popularlibs.R;

/*
Создать RetrofitActivity. В активити получить строчку с
https://api.github.com/users/JakeWharton и отобразить аватарку по avatar_url.
Использовать библиотеку retrofit.
*/

public class RetrofitActivity extends AppCompatActivity {
    private GitApi gitApi;

    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);

        apiInit();
    }

    private void apiInit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gitApi = retrofit.create(GitApi.class);
    }

    @OnClick(R.id.button)
    void onButtonClick() {
        gitApi.loadUserData("JakeWharton").enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.body() != null) {
                    CircularProgressDrawable circularProgressDrawable =
                            new CircularProgressDrawable(RetrofitActivity.this);
                    circularProgressDrawable.setStrokeWidth(5f);
                    circularProgressDrawable.setCenterRadius(30f);
                    circularProgressDrawable.start();

                    Glide
                            .with(RetrofitActivity.this)
                            .load(response.body().avatarUrl)
                            .placeholder(circularProgressDrawable)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
                            .into(image);
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                image.setImageResource(R.drawable.ic_error_black_24dp);
            }
        });
    }
}
