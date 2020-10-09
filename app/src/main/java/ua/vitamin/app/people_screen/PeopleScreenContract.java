package ua.vitamin.app.people_screen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import ua.vitamin.app.utils.Result;
import ua.vitamin.app.utils.User;

public interface PeopleScreenContract {
    public interface MainView {
        public void onShowListPeople(List<Result> listPeople);
    }

    public interface MainPresenter {
        public void onPostListLoad();
    }

    public interface MainModel {
        public CompletableFuture<User> fetchPeopleList();
    }
}
