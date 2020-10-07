package ua.vitamin.app.people_screen.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ua.vitamin.app.utils.Result;

public interface RequestHandler {
    @GET("api?results=10")
    public Call<List<Result>> getPeople();
}
