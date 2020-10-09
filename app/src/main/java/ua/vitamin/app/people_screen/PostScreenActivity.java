package ua.vitamin.app.people_screen;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ua.vitamin.app.utils.Result;
import ua.vitamin.redditapp.R;

public class PostScreenActivity extends AppCompatActivity implements PeopleScreenContract.MainView {

    private PeopleScreenContract.MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new PeopleScreenPresenter(this, new PostScreenModel());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onPostListLoad();
    }

    @Override
    public void onShowListPeople(List<Result> listPeople) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(listPeople.get(0).getEmail());
        Log.d("LIST_PEOPLE", listPeople.get(0).getGender());
    }
}