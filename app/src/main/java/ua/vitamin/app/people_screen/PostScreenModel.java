package ua.vitamin.app.people_screen;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.vitamin.app.people_screen.utils.RequestHandler;
import ua.vitamin.app.utils.Result;

public class PostScreenModel implements Contract.MainModel {

    private String responseString;
    private String url;
    private HttpsURLConnection connection;
    private BufferedReader bufferedReader;
    private StringBuilder sb;
    private InputStream inputStream;
    private List<Result> peopleList;

    @Override
    public List<Result> loadPeople() {
        Executor executor = Executors.newFixedThreadPool(10);

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
                    peopleList = response.body();
                }

                @Override
                public void onFailure(Call<List<Result>> call, Throwable t) {
                    t.printStackTrace();
                    Log.d("ERRRROOOORRR", Objects.requireNonNull(t.getLocalizedMessage()));
                }
            });
        }, executor);

        try {
            resultCompletableFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return peopleList;
    }
}
