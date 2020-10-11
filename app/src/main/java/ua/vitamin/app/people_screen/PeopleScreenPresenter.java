package ua.vitamin.app.people_screen;

import android.util.Log;

import java.util.List;

import ua.vitamin.app.utils.Results;
import ua.vitamin.app.utils.User;

public class PeopleScreenPresenter implements PeopleScreenContract.MainPresenter {
    private static final String TAG = "PeopleScreenPresenter";

    private PeopleScreenContract.MainView postScreenActivityView;
    private PeopleScreenContract.MainModel postScreenModel;

    public PeopleScreenPresenter (PeopleScreenContract.MainView mainActivity, PeopleScreenContract.MainModel mainModel) {
        Log.d(TAG, "PeopleScreenPresenter()");
        this.postScreenActivityView = mainActivity;
        this.postScreenModel = mainModel;
    }

    @Override
    public void onPostListLoad() {
        Log.d(TAG, "onPostListLoad()");
        postScreenModel.fetchPeopleList().whenComplete((userResult, throwable) -> {
            if (throwable != null) {
                throwable.getLocalizedMessage();
            }

            User user = userResult.getValue();

            if (user != null) {
                postScreenActivityView.onShowListPeople(user.results);
            }
        });
    }
}
