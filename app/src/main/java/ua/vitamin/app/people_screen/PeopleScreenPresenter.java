package ua.vitamin.app.people_screen;

import android.util.Log;
import java.util.List;
import ua.vitamin.app.utils.Result;

public class PeopleScreenPresenter implements Contract.MainPresenter {
    private static final String TAG = "PeopleScreenPresenter";

    private Contract.MainView postScreenActivityView;
    private PostScreenModel postScreenModel;
    private List<Result> peopleList;

    public PeopleScreenPresenter (Contract.MainView mainActivity) {
        Log.d(TAG, "PeopleScreenPresenter()");
        this.postScreenActivityView = mainActivity;
        this.postScreenModel = new PostScreenModel();
    }

    @Override
    public void onPostListLoad() {
        Log.d(TAG, "onPostListLoad()");
        peopleList = postScreenModel.loadPeople();
        postScreenActivityView.onShowListPeople(peopleList);
    }
}
