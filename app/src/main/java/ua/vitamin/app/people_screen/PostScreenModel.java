package ua.vitamin.app.people_screen;

import android.util.Log;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.vitamin.app.people_screen.utils.RequestHandler;
import ua.vitamin.app.utils.User;

public class PostScreenModel implements PeopleScreenContract.MainModel {

    @Override
    public CompletableFuture<Result<User>> fetchPeopleList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestHandler handler = retrofit.create(RequestHandler.class);
        CompletableFuture<Result<User>> future = new CompletableFuture();
        handler.getPeople().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                future.complete(Result.value(response.body()));
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                future.complete(Result.throwable(t));
            }
        });

        return future;
    }
}
