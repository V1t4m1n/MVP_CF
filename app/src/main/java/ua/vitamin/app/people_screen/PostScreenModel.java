package ua.vitamin.app.people_screen;

import android.util.Log;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.vitamin.app.people_screen.utils.RequestHandler;
import ua.vitamin.app.utils.Result;

public class PostScreenModel implements PeopleScreenContract.MainModel {

    @Override
    public CompletableFuture<Void> fetchPeopleList() {
        final List<Result>[] peopleList = new List[]{Collections.emptyList()};

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestHandler handler = retrofit.create(RequestHandler.class);
        Call<List<Result>> call = handler.getPeople();

        CompletableFuture<Void> resultCompletableFuture = CompletableFuture.runAsync(() -> {
            call.enqueue(new Callback<List<Result>>() {
                @Override
                public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                    peopleList[0] = response.body();
                }

                @Override
                public void onFailure(Call<List<Result>> call, Throwable t) {
                    t.printStackTrace();
                    Log.d("PostScreenModel.loadPeople", Objects.requireNonNull(t.getLocalizedMessage()));
                }
            });
        });

        return resultCompletableFuture;
    }
}
