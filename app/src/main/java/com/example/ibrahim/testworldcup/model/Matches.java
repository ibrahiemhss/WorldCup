package com.example.ibrahim.testworldcup.model;

public class Matches {
    long id;
    String away_team;
    String home_team;
    long away_result;
    long home_result;
    String date;


    String stadium;
    String finished;
    String type;

    public Matches (long id, String away_team, String home_team, long away_result, long home_result, String date, String stadium, String finished, String type) {
        this.id = id;
        this.away_team = away_team;
        this.home_team = home_team;
        this.away_result = away_result;
        this.home_result = home_result;
        this.date = date;
        this.stadium = stadium;
        this.finished = finished;
        this.type = type;
    }

    public Matches (long aLong, String string, String string1, String string2, long aLong1, long aLong2, String string3, String string4, String string5, String string6) {
    }

    public long getAway_result () {
        return away_result;
    }

    public void setAway_result (long away_result) {
        this.away_result = away_result;
    }

    public long getHome_result () {
        return home_result;
    }

    public void setHome_result (long home_result) {
        this.home_result = home_result;
    }
    public String getHome_team () {
        return home_team;
    }

    public void setHome_team (String home_team) {
        this.home_team = home_team;
    }
    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getAway_team () {
        return away_team;
    }

    public void setAway_team (String away_team) {
        this.away_team = away_team;
    }

    public String getHome_teame () {
        return home_team;
    }

    public void setHome_teame (String home_teame) {
        this.home_team = home_teame;
    }


    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getStadium () {
        return stadium;
    }

    public void setStadium (String stadium) {
        this.stadium = stadium;
    }


    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getFinished () {
        return finished;
    }

    public void setFinished (String finished) {
        this.finished = finished;
    }
}
