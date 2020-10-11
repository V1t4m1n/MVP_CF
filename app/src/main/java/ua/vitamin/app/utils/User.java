package ua.vitamin.app.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("result")
    @Expose
    public List <Results> results;
}
