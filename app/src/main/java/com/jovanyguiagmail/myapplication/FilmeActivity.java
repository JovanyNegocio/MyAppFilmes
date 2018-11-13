package com.jovanyguiagmail.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmeActivity extends AppCompatActivity {

    ImageView filmeDetailImage;
    TextView filmeDescription;
    TextView filmename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int res = getIntent().getIntExtra("filme_image", R.drawable.filmeinterstellar);
        String name = getIntent().getStringExtra("filme_name");
        String description = getIntent().getStringExtra("filme_description");

        filmeDetailImage = findViewById(R.id.filme_image);
        filmeDetailImage.setImageResource(res);

        filmeDescription = findViewById(R.id.filme_description);
        filmeDescription.setText(description);

        filmename = findViewById(R.id.filme_name);
        filmename.setText(name);

    }

}
