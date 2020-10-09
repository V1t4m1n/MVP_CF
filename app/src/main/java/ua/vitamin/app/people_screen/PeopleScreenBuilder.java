package ua.vitamin.app.people_screen;

public class PeopleScreenBuilder {

    private PeopleScreenContract.MainPresenter mainPresenter;
    private PeopleScreenContract.MainModel mainModel;
    private PeopleScreenContract.MainView mainView;

    public static class Builder {
        private PeopleScreenBuilder builder;

        public Builder () {
            this.builder = new PeopleScreenBuilder();
        }

        public Builder setView (PeopleScreenContract.MainView view) {
            this.builder.mainView = view;
            return this;
        }

        public Builder setPresenter (PeopleScreenContract.MainPresenter  presenter) {
            this.builder.mainPresenter = presenter;
            return this;
        }

        public Builder setModel (PeopleScreenContract.MainModel model) {
            this.builder.mainModel = model;
            return this;
        }

        public static PeopleScreenBuilder build() {
            return new PeopleScreenBuilder();
        }
    }
}
