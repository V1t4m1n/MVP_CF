package ua.vitamin.app.people_screen.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import ua.vitamin.app.utils.User;

public interface RequestHandler {
    @GET("api?results=10")
    public Call<User> getPeople();
}
