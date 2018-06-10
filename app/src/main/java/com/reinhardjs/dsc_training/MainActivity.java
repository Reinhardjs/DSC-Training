package com.reinhardjs.dsc_training;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.reinhardjs.dsc_training.Training1.Training1Activity;
import com.reinhardjs.dsc_training.Training2.Training2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button training1Btn = findViewById(R.id.train1Btn);
        Button training2Btn = findViewById(R.id.train2Btn);

        training1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Training1Activity.class);
                startActivity(intent);
            }
        });

        training2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Training2Activity.class);
                startActivity(intent);
            }
        });
    }
}
