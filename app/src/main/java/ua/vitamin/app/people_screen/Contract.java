package ua.vitamin.app.people_screen;

import java.util.List;

import ua.vitamin.app.utils.Result;

public interface Contract {
    public interface MainView {
        public void onShowListPeople(List<Result> listPeople);
    }

    public interface MainPresenter {
        public void onPostListLoad();
    }

    public interface MainModel {
        public List<Result> loadPeople();
    }
}
