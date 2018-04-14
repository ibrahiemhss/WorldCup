package com.example.ibrahim.testworldcup.model;

/**
 * Created by ibrahim on 14/04/18.
 */

public class Channels {
    long id;
    String name;
    String icon;

    public Channels (long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getIcon () {
        return icon;
    }

    public void setIcon (String icon) {
        this.icon = icon;
    }
}
