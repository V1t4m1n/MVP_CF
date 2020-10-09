package ua.vitamin.app.people_screen;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import ua.vitamin.redditapp.R;
import ua.vitamin.app.utils.Result;

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
        Log.d("LIST", listPeople.get(0).getEmail());
        TextView textView = findViewById(R.id.textView);
        textView.setText(listPeople.get(0).getEmail());
    }
}