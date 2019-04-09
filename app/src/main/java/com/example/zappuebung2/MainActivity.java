package com.example.zappuebung2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    RecyclerView mRecyclerView;
    AdapterRecyclerView adapter;
    ArrayList<String> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(layoutManager);

        mItems = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 50; i++)
            mItems.add(((char) ('A' + rnd.nextInt('Z' - 'A'))) + " " +
                    Integer.toString(i));
        Collections.sort(mItems);

        adapter = new AdapterRecyclerView(this, mItems);
        mRecyclerView.setAdapter(adapter);
    }
}
