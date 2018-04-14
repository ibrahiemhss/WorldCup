package com.example.ibrahim.testworldcup.model;

/**
 * Created by ibrahim on 07/04/18.
 */

public class Teams {
    String name;
    String iso2;
    String flag;//
    Long  id;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getIso2 () {
        return iso2;
    }

    public void setIso2 (String iso2) {
        this.iso2 = iso2;
    }

    public String getFlag () {
        return flag;
    }

    public void setFlag (String flag) {
        this.flag = flag;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }
}
