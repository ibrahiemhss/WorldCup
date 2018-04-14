package com.example.ibrahim.testworldcup.model;

/**
 * Created by ibrahim on 14/04/18.
 */

public class Stadiums {
    long id;
    String city;
    double lat;
    double lng;
    String name;

    public Stadiums (long id, String city, double lat, double lng, String name) {
        this.id = id;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }



    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getCity () {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public double getLat () {
        return lat;
    }

    public void setLat (double lat) {
        this.lat = lat;
    }

    public double getLng () {
        return lng;
    }

    public void setLng (double lng) {
        this.lng = lng;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
