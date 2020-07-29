package com.example.travely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PlacesActivity extends AppCompatActivity {

    private RecyclerView rvLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        rvLists = findViewById(R.id.rvLists);

        // TODO: steps to creating a Recycler View
        // 0. create layout for one row in the list
        // 1. create the adapater
        // 2. create the data source
        // 3. set the adapter on the recycler view
        // 4. set the layout manager on the recycler view

    }
}