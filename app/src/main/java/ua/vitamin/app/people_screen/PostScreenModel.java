package ua.vitamin.app.people_screen;

import android.util.Log;

import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.vitamin.app.people_screen.utils.RequestHandler;
import ua.vitamin.app.utils.User;

public class PostScreenModel implements PeopleScreenContract.MainModel {

   private User peopleList;

    @Override
    public CompletableFuture<User> fetchPeopleList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestHandler handler = retrofit.create(RequestHandler.class);
        Call<User> call = handler.getPeople();

        return CompletableFuture.supplyAsync(() -> {
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call1, Response<User> response) {
                    Log.d("PostScreenModel.loadPeople", "onResponse");
                    peopleList = response.body();
                }

                @Override
                public void onFailure(Call<User> call1, Throwable t) {
                    Log.d("PostScreenModel.loadPeople", "onFailure");
                    t.printStackTrace();
                }
            });
            return peopleList;
        });
    }
}
