package com.reinhardjs.dsc_training.Training1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;

import com.reinhardjs.dsc_training.R;
import com.reinhardjs.dsc_training.Training1.Fragments.FragmentRV;

public class Training1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training1);

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
