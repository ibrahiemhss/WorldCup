package com.example.ibrahim.testworldcup.data.local.models;

public class Matches {
    String TeamA;
    String TeamB;
    String date;
    String image_for_teamA;
    String image_for_teamB;

    public Matches (String teamA, String teamB) {
        TeamA = teamA;
        TeamB = teamB;
    }

    String stadium;
    String finished;

    public String getTeamA () {
        return TeamA;
    }

    public void setTeamA (String teamA) {
        TeamA = teamA;
    }

    public String getTeamB () {
        return TeamB;
    }

    public void setTeamB (String teamB) {
        TeamB = teamB;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getImage_for_teamA () {
        return image_for_teamA;
    }

    public void setImage_for_teamA (String image_for_teamA) {
        this.image_for_teamA = image_for_teamA;
    }

    public String getImage_for_teamB () {
        return image_for_teamB;
    }

    public void setImage_for_teamB (String image_for_teamB) {
        this.image_for_teamB = image_for_teamB;
    }

    public String getStadium () {
        return stadium;
    }

    public void setStadium (String stadium) {
        this.stadium = stadium;
    }

    public String getFinished () {
        return finished;
    }

    public void setFinished (String finished) {
        this.finished = finished;
    }
}
