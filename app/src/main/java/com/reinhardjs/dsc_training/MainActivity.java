package com.reinhardjs.dsc_training;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;

import com.reinhardjs.dsc_training.Fragments.FragmentDetail;
import com.reinhardjs.dsc_training.Fragments.FragmentRV;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;

        fragmentTransaction = fragmentManager.beginTransaction();
        FragmentRV fragment = new FragmentRV();
        fragment.setExitTransition(new Slide(Gravity.LEFT));
        fragment.setAllowEnterTransitionOverlap(false);
        fragmentTransaction.add(R.id.fragment, fragment, "Fragment RV");
        fragmentTransaction.commit();


    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
