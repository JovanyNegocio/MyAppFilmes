package com.jovanyguiagmail.myapplication;

public class Filme {
    String path;
    String name;
    String description;

    public Filme(String path, String name, String description) {
        this.path = path;
        this.name = name;
        this.description = description;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
