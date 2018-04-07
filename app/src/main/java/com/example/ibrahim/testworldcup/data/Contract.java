package com.example.ibrahim.testworldcup.data;

public class Contract {

    public static final String AUTHORITY = "http://worldcupapp2018.000webhostapp.com/";
    public static final String URL_SYNC = "http://worldcupapp2018.000webhostapp.com/getMatches.php";


    //TODO constants for SQlite database
    //database name
    public static final String TAG = "worldCup";
    public static final String DATABASE_NAME="worldCup";
    //the id column for all tables
    public static final String ID="id";



 public static final String TB_MATCHES="tb_matches";
    public static final String TEAM_A="TeamA";
    public static final String TEAM_B="TeamB";
    public static final String DATE="date";
    public static final String IMAGE_FOR_TEAM_A="image_for_teamA";
    public static final String IMAGE_FOR_TEAM_B="image_for_teamB";
    public static final String STADIUM="stadium";
    public static final String FINISHED="finished";



    //database tables for teames
    public static final String TB_TEAMES="tb_teames";
    public static final String TEAM_NAME="team_name";
    public static final String GROUPS="groups";
    public static final String PLAYED="palyed";
    public static final String WIN="win";
    public static final String DRAW="draw";
    public static final String LOSE="lose";
    public static final String SCORE="score";
    public static final String GOALS="goals";
    public static final String ACTIVE="active";
    public static final String IMAGE_FOR_TEAM="image_for_team";




}
