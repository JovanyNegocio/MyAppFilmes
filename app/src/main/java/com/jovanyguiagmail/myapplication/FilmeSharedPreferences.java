package com.jovanyguiagmail.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class FilmeSharedPreferences {

    public static void saveFilmeList(List<Filme> filmes, Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(filmes);
        editor.putString(key, json);
        editor.apply();

    }

    public static List<Filme> loadFilmeList(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = preferences.getString(key, null);
        Type type = new TypeToken<List<Filme>>() {}.getType();
        return gson.fromJson(json, type);
    }
}
