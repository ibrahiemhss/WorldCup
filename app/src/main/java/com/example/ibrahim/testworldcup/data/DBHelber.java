package com.example.ibrahim.testworldcup.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.ibrahim.testworldcup.data.Contract.AWAY_RESULT;
import static com.example.ibrahim.testworldcup.data.Contract.CITY;
import static com.example.ibrahim.testworldcup.data.Contract.DATABASE_NAME;
import static com.example.ibrahim.testworldcup.data.Contract.DATE;
import static com.example.ibrahim.testworldcup.data.Contract.FINISHED;
import static com.example.ibrahim.testworldcup.data.Contract.FK_AWAY_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.FK_AWAY_TEAM_FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.FK_CHANNELS;
import static com.example.ibrahim.testworldcup.data.Contract.FK_HOME_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.FK_HOME_TEAM_FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.FK_STADIUM;
import static com.example.ibrahim.testworldcup.data.Contract.FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_A;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_B;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_C;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_D;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_E;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_F;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_G;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_H;
import static com.example.ibrahim.testworldcup.data.Contract.HOME_RESULT;
import static com.example.ibrahim.testworldcup.data.Contract.ICON;
import static com.example.ibrahim.testworldcup.data.Contract.ID;

import static com.example.ibrahim.testworldcup.data.Contract.ISO2;
import static com.example.ibrahim.testworldcup.data.Contract.LAT;
import static com.example.ibrahim.testworldcup.data.Contract.LNG;
import static com.example.ibrahim.testworldcup.data.Contract.NAME;
import static com.example.ibrahim.testworldcup.data.Contract.TB_GROUPS;
import static com.example.ibrahim.testworldcup.data.Contract.TB_MATCHES;
import static com.example.ibrahim.testworldcup.data.Contract.TB_STADIUMS;
import static com.example.ibrahim.testworldcup.data.Contract.TB_TEAMES;
import static com.example.ibrahim.testworldcup.data.Contract.TB_TV_CHANNELS;
import static com.example.ibrahim.testworldcup.data.Contract.TYPE;


public class DBHelber extends SQLiteOpenHelper {

    private static final int SCHEMA = 2;
    private static final String TAG = DBHelber.class.getSimpleName ();

    public DBHelber (Context context) {
        super (context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate (SQLiteDatabase sqLiteDatabase) {
        //TODO creating table of users
   final String CREATE_TB_STADIUMS =
                "CREATE TABLE " + TB_STADIUMS + "(" +
                        ID + " INTEGER PRIMARY KEY , " +
                        CITY + " VARCHAR(100) NOT NULL, " +
                        NAME + " VARCHAR(100) NOT NULL, " +
                        LAT + " VARCHAR(100) NOT NULL, " +
                        LNG + " VARCHAR(100) NOT NULL " +")";


        final String CREATE_TV_CHANNELS =
                "CREATE TABLE " + TB_TV_CHANNELS + "(" +
                        ID + " INTEGER PRIMARY KEY , " +
                        NAME + " VARCHAR(100) NOT NULL, " +
                        ICON + " VARCHAR(100) NOT NULL " +")";



        final String CREATE_TB_TEAMS =
                "CREATE TABLE " + TB_TEAMES + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                        NAME + " VARCHAR(100) NOT NULL  ,  " +
                        FLAG + " VARCHAR(400) NOT NULL  ,  " +
                        ISO2 + " VARCHAR(10) NOT NULL  " +")";

        final String CREATE_GROUPS=
                "CREATE TABLE " + TB_GROUPS + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                        GROUP_A + " VARCHAR(10) NOT NULL  ,  " +
                        GROUP_B + " VARCHAR(10) NOT NULL  ,  " +
                        GROUP_C + " VARCHAR(10) NOT NULL  ,  " +
                        GROUP_D + " VARCHAR(10) NOT NULL  ,  " +
                        GROUP_E + " VARCHAR(10) NOT NULL  ,  " +
                        GROUP_F + " VARCHAR(10) NOT NULL  ,  " +
                        GROUP_G + " VARCHAR(10) NOT NULL  ,  " +
                        GROUP_H+ " VARCHAR(10) NOT NULL  " +")";

        final String CREATE_TB_MATCHES =
                "CREATE TABLE " + TB_MATCHES + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                        TYPE + " VARCHAR(10) NOT NULL  ," +
                        HOME_RESULT+" INTEGER , "+
                        AWAY_RESULT+" INTEGER , "+
                        DATE+" DATE , "+
                        FINISHED + " VARCHAR(10) NOT NULL  ," +
                        FK_HOME_TEAM+" INTEGER, "+
                        FK_AWAY_TEAM+" INTEGER, "+
                        FK_HOME_TEAM_FLAG+" INTEGER, "+
                        FK_AWAY_TEAM_FLAG+" INTEGER, "+
                        FK_STADIUM+" INTEGER, "+
                        FK_CHANNELS+" INTEGER, "+
                        "FOREIGN KEY("+FK_HOME_TEAM+") REFERENCES "+TB_TEAMES+" ("+ID+"), "+
                        "FOREIGN KEY("+FK_AWAY_TEAM+") REFERENCES "+TB_TEAMES+" ("+ID+") ,"+
                        "FOREIGN KEY("+FK_HOME_TEAM_FLAG+") REFERENCES "+TB_TEAMES+" ("+ID+"), "+
                       "FOREIGN KEY("+FK_AWAY_TEAM_FLAG+") REFERENCES "+TB_TEAMES+" ("+ID+"), "+
                        "FOREIGN KEY("+FK_STADIUM+") REFERENCES "+TB_STADIUMS+" ("+ID+"), "+
                        "FOREIGN KEY("+FK_CHANNELS+") REFERENCES "+TB_TV_CHANNELS+" ("+ID+")"+")";



                        //  FINISHED + " EXT CHECK( pType IN ('yes','no') ) NOT NULL DEFAULT  'no' "+")";

//        FINISHED + " EXT CHECK( pType IN ('yes','no') ) NOT NULL DEFAULT 'no')";
        sqLiteDatabase.execSQL (CREATE_TB_STADIUMS);
        sqLiteDatabase.execSQL (CREATE_TV_CHANNELS);
        sqLiteDatabase.execSQL (CREATE_TB_TEAMS);
        sqLiteDatabase.execSQL (CREATE_GROUPS);
       sqLiteDatabase.execSQL (CREATE_TB_MATCHES);


    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1) {
        throw new UnsupportedOperationException ("This shouldn't happen yet!");

    }
    //add to all contentnts of stadiums in sqlite
    public void addStadiumsList(long id, String city, double lat, double lng, String name) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( ID, id );
        values.put( CITY, city );
        values.put( NAME, name );
        values.put( LAT, lat );
        values.put( LNG, lng );
        long query = db.insertWithOnConflict( TB_STADIUMS, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_STADIUMS, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        Log.d( TAG, "add TB_MATCHES list inserted into sqlite: " + query );

        db.close();
    }
    //add to all contentnts of channels in sqlite
    public void addChannelsList(long id, String name, String icon) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( ID, id );
        values.put( NAME, name );
        values.put( ICON, icon );
        long query = db.insertWithOnConflict( TB_TV_CHANNELS, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_TV_CHANNELS, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        Log.d( TAG, "add TB_TV_CHANNELS list inserted into sqlite: " + query );
        db.close();
    }

    //add to all contentnts of channels in sqlite
    public void addTeamsList(long id, String name,String flag,String iso2) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( ID, id );
        values.put( NAME, name );
        values.put( FLAG, flag );
        values.put( ISO2, iso2 );
        long query = db.insertWithOnConflict( TB_TEAMES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_TEAMES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        Log.d( TAG, "add TB_TEAMES  list inserted into sqlite: " + query );
        db.close();
    }
    public void addMathesList(long id,  String type, long home_team,
                              long away_team, long home_result,long away_result,String date, long stadium,long channels, boolean finished) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

     values.put( ID, id );
        values.put( TYPE, type );
        values.put( FK_HOME_TEAM, home_team );
        values.put( FK_AWAY_TEAM, away_team );
        values.put( HOME_RESULT, home_result );
        values.put( AWAY_RESULT, away_result );
       values.put( DATE, date );
        values.put( FK_STADIUM, stadium );
        values.put( FK_CHANNELS, channels );
        values.put( FINISHED, finished );



        long query = db.insertWithOnConflict( TB_MATCHES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_MATCHES, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add TB_MATCHES list inserted into sqlite: " + query );


        db.close();
    }

    public Cursor getMatchesList() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TB_MATCHES+"";

        Cursor c = db.rawQuery(sql, null);
        return c;
    }
}
