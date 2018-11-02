package com.jovanyguiagmail.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView filmeRecyclerView;
    FilmeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmeRecyclerView = findViewById(R.id.filme_view);
        filmeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FilmeAdapter(this);
        filmeRecyclerView.setAdapter(adapter);
    }
}