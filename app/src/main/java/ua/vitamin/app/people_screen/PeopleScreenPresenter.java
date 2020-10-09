package ua.vitamin.app.people_screen;

import android.util.Log;

import java.util.List;

import ua.vitamin.app.utils.Result;

public class PeopleScreenPresenter implements PeopleScreenContract.MainPresenter {
    private static final String TAG = "PeopleScreenPresenter";

    private PeopleScreenContract.MainView postScreenActivityView;
    private PeopleScreenContract.MainModel postScreenModel;
    private List<Result> peopleList;

    public PeopleScreenPresenter (PeopleScreenContract.MainView mainActivity) {
        Log.d(TAG, "PeopleScreenPresenter()");
        this.postScreenActivityView = mainActivity;
        this.postScreenModel = new PostScreenModel();
    }

    public PeopleScreenPresenter (PeopleScreenContract.MainModel mainModel) {
        Log.d(TAG, "PeopleScreenPresenter()");
        this.postScreenModel = mainModel;
    }

    public PeopleScreenPresenter (PeopleScreenContract.MainView mainActivity, PeopleScreenContract.MainModel mainModel) {
        Log.d(TAG, "PeopleScreenPresenter()");
        this.postScreenActivityView = mainActivity;
        this.postScreenModel = mainModel;

    }


    @Override
    public void onPostListLoad() {
        Log.d(TAG, "onPostListLoad()");
        postScreenModel.fetchPeopleList().handleAsync((aVoid, throwable) -> {postScreenActivityView.onShowListPeople(peopleList); return this;});
        //postScreenActivityView.onShowListPeople(peopleList);
    }
}
