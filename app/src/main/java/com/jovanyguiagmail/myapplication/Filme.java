package com.jovanyguiagmail.myapplication;

public class Filme {
    int res;
    String name;
    String description;

    public Filme(int res, String name, String description) {
        this.res = res;
        this.name = name;
        this.description = description;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
