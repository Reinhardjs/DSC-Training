package com.reinhardjs.dsc_training.Training2;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.reinhardjs.dsc_training.R;

import java.util.ArrayList;

public class Training2Activity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SearchView searchView = toolbar.findViewById(R.id.searchView);
        searchView.onActionViewCollapsed();

        CustomRecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayout bottomFreeSpace = findViewById(R.id.freespace);
        recyclerView.init(linearLayoutManager, bottomFreeSpace);

        ArrayList<RecyclerViewData> dataList = new ArrayList<>();
        dataList.add(new RecyclerViewData("London, United Kingdom", "18", R.drawable.sunny));
        dataList.add(new RecyclerViewData("San Francisco, United States", "8", R.drawable.rain));
        dataList.add(new RecyclerViewData("Stockholm, Sweden", "10", R.drawable.sunny_rain));
        dataList.add(new RecyclerViewData("London, United Kingdom", "18", R.drawable.sunny));
        dataList.add(new RecyclerViewData("Stockholm, Sweden", "10", R.drawable.sunny_rain));
        dataList.add(new RecyclerViewData("San Francisco, United States", "8", R.drawable.rain));
        dataList.add(new RecyclerViewData("London, United Kingdom", "18", R.drawable.sunny));
        dataList.add(new RecyclerViewData("Stockholm, Sweden", "10", R.drawable.sunny_rain));
        dataList.add(new RecyclerViewData("San Francisco, United States", "8", R.drawable.rain));
        dataList.add(new RecyclerViewData("London, United Kingdom", "18", R.drawable.sunny));
        dataList.add(new RecyclerViewData("Stockholm, Sweden", "10", R.drawable.sunny_rain));
        dataList.add(new RecyclerViewData("San Francisco, United States", "8", R.drawable.rain));
        dataList.add(new RecyclerViewData("London, United Kingdom", "18", R.drawable.sunny));
        dataList.add(new RecyclerViewData("Stockholm, Sweden", "10", R.drawable.sunny_rain));
        dataList.add(new RecyclerViewData("San Francisco, United States", "8", R.drawable.rain));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), dataList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
