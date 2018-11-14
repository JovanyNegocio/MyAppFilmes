package com.jovanyguiagmail.myapplication;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    //https://github.com/square/picasso
    //picasso
    //https://github.com/google/gson
    //gson

    RecyclerView filmeRecyclerView;
    FilmeAdapter adapter;
    Dialog addItemDialog;
    ImageView newImage;
    EditText newTitle;
    EditText newDescription;
    Button saveButton;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmeRecyclerView = findViewById(R.id.filme_view);
        filmeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FilmeAdapter(this);
        filmeRecyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

            }
        });
    }

    public void showDialog() {
        addItemDialog = new Dialog(MainActivity.this);
        addItemDialog.setContentView(R.layout.add_item_dialog);

        newImage = addItemDialog.findViewById(R.id.new_image);
        newImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isStoregePermissionGranted()) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK);
                    galleryIntent.setType("image/*");
                    startActivityForResult(galleryIntent, 12);
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                }
            }
        });

        newTitle = addItemDialog.findViewById(R.id.new_title);
        newDescription = findViewById(R.id.new_description);

        saveButton = addItemDialog.findViewById(R.id.salvar);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewItem();
            }
        });

        addItemDialog.setTitle("Adicionar novo item");
        addItemDialog.show();

    }

    public void saveNewItem() {
        if(newTitle.getText() .toString().isEmpty() || newDescription.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Os campos nao podem estar nulos", Toast.LENGTH_LONG).show();
        } else {
            String title = newTitle.getText().toString();
            String description = newDescription.getText().toString();
            adapter.filmes.add(new Filme(title, description, path));
            adapter.notifyDataSetChanged();
            path = null;
            addItemDialog.dismiss();

        }
    }

    public boolean isStoregePermissionGranted() {
        return ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Uri uri = data.getData();
            Log.i( "MainActivity", "Localizacao do ficheiro: " + uri.getPath());
            path = getRealPathFromURI(uri);
            File file = new File(path);
            Picasso.get().load(file).into(newImage);
        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        Cursor cursor = getContentResolver().
                query(contentURI, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        String result = cursor.getString(idx);
        cursor.close();
        return result;
    }
}