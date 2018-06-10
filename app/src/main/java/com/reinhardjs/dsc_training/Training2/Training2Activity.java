package com.reinhardjs.dsc_training.Training2;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.reinhardjs.dsc_training.MainActivity;
import com.reinhardjs.dsc_training.R;

public class Training2Activity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        SearchView searchView = toolbar.findViewById(R.id.searchView);
        searchView.onActionViewCollapsed();

        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(this);
    }

    float dY, lastY;
    int lastAction;

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                lastY = event.getRawY();
                dY = view.getY() - event.getRawY();
                lastAction = MotionEvent.ACTION_DOWN;
                break;

            case MotionEvent.ACTION_MOVE:

                boolean isNotReachTop = Float.valueOf(event.getRawY()+dY) >= Float.valueOf(165.0f);
                boolean isNotOnBottomReach = Float.valueOf(event.getRawY()+dY) <= Float.valueOf(700.0f);

                lastY = event.getRawY();

                if (isNotReachTop && isNotOnBottomReach)
                view.setY(event.getRawY() + dY);

                lastAction = MotionEvent.ACTION_MOVE;

                break;

            case MotionEvent.ACTION_UP:
                if (lastAction == MotionEvent.ACTION_DOWN)
                break;

            default:
                return false;
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
