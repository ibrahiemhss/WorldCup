package com.example.ibrahim.testworldcup.model;

/**
 * Created by ibrahim on 07/04/18.
 */

public class Teams {
    String teamName;
    String groups;
    String image;//
    Long  id;
    Long score;
    Long win;
    Long played;
    Long lose;
    Long goals;

    public Long getScore () {
        return score;
    }

    public void setScore (Long score) {
        this.score = score;
    }

    public Long getWin () {
        return win;
    }

    public void setWin (Long win) {
        this.win = win;
    }

    public Long getPlayed () {
        return played;
    }

    public void setPlayed (Long played) {
        this.played = played;
    }

    public Long getLose () {
        return lose;
    }

    public void setLose (Long lose) {
        this.lose = lose;
    }

    public Long getGoals () {
        return goals;
    }

    public void setGoals (Long goals) {
        this.goals = goals;
    }

    public Long getDraw () {
        return draw;
    }

    public void setDraw (Long draw) {
        this.draw = draw;
    }

    Long draw;

    public String getActive () {
        return active;
    }

    public void setActive (String active) {
        this.active = active;
    }

    String active;//,

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }


    public String getImage () {
        return image;
    }

    public void setImage (String image) {
        this.image = image;
    }


    public String getTeamName () {
        return teamName;
    }

    public void setTeamName (String teamName) {
        this.teamName = teamName;
    }

    public String getGroups () {
        return groups;
    }

    public void setGroups (String groups) {
        this.groups = groups;
    }


}
