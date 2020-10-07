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
    }

    public PeopleScreenPresenter (PeopleScreenContract.MainModel mainModel) {
        Log.d(TAG, "PeopleScreenPresenter()");
        this.postScreenModel = mainModel;
    }

    public PeopleScreenPresenter (PeopleScreenContract.MainModel mainModel, PeopleScreenContract.MainView mainActivity) {
        Log.d(TAG, "PeopleScreenPresenter()");
        this.postScreenModel = mainModel;
        this.postScreenActivityView = mainActivity;
    }


    @Override
    public void onPostListLoad() {
        Log.d(TAG, "onPostListLoad()");
        peopleList = (List<Result>) postScreenModel.fetchPeopleList().handleAsync((aVoid, throwable) -> {postScreenActivityView.onShowListPeople(peopleList); return peopleList;});
        postScreenActivityView.onShowListPeople(peopleList);
    }

    public void loadPeople() {
        this.peopleList = (List<Result>) postScreenModel.fetchPeopleList().handleAsync((aVoid, throwable) -> {postScreenActivityView.onShowListPeople(peopleList); return peopleList;});
    }
}
