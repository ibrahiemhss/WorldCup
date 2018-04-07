package com.example.ibrahim.testworldcup.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.ibrahim.testworldcup.data.Contract.ACTIVE;
import static com.example.ibrahim.testworldcup.data.Contract.DATABASE_NAME;
import static com.example.ibrahim.testworldcup.data.Contract.DATE;
import static com.example.ibrahim.testworldcup.data.Contract.DRAW;
import static com.example.ibrahim.testworldcup.data.Contract.GOALS;
import static com.example.ibrahim.testworldcup.data.Contract.GROUPS;
import static com.example.ibrahim.testworldcup.data.Contract.ID;
import static com.example.ibrahim.testworldcup.data.Contract.IMAGE_FOR_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.IMAGE_FOR_TEAM_A;
import static com.example.ibrahim.testworldcup.data.Contract.IMAGE_FOR_TEAM_B;
import static com.example.ibrahim.testworldcup.data.Contract.LOSE;
import static com.example.ibrahim.testworldcup.data.Contract.PLAYED;
import static com.example.ibrahim.testworldcup.data.Contract.SCORE;
import static com.example.ibrahim.testworldcup.data.Contract.STADIUM;
import static com.example.ibrahim.testworldcup.data.Contract.TB_MATCHES;
import static com.example.ibrahim.testworldcup.data.Contract.TB_TEAMES;
import static com.example.ibrahim.testworldcup.data.Contract.TEAM_A;
import static com.example.ibrahim.testworldcup.data.Contract.TEAM_B;
import static com.example.ibrahim.testworldcup.data.Contract.TEAM_NAME;
import static com.example.ibrahim.testworldcup.data.Contract.WIN;

public class DBHelber extends SQLiteOpenHelper {

    private static final int SCHEMA = 1;
    private static final String TAG = DBHelber.class.getSimpleName ();

    public DBHelber (Context context) {
        super (context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate (SQLiteDatabase sqLiteDatabase) {
        //TODO creating table of users

        final String CREATE_TB_TEAMS =
                "CREATE TABLE " + TB_TEAMES + "(" +
                        ID + " INTEGER PRIMARY KEY , " +
                        TEAM_NAME + " VARCHAR(100) NOT NULL, " +
                        GROUPS + " VARCHAR(100) NOT NULL, " +
                        PLAYED + " INTEGER ," +
                        WIN + " INTEGER ," +
                        DRAW + " INTEGER ," +
                        LOSE + " INTEGER ," +
                        SCORE + " INTEGER ," +
                        GOALS + " INTEGER ," +
                        IMAGE_FOR_TEAM + " VARCHAR(100) NOT NULL, " +
                        ACTIVE + " EXT CHECK( pType IN ('yes','no') ) NOT NULL DEFAULT 'no' "+")";
        final String CREATE_TB_MATCHES =
                "CREATE TABLE " + TB_MATCHES + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                        TEAM_A + " VARCHAR(100) NOT NULL  ,  " +
                        TEAM_B + " VARCHAR(100) NOT NULL  ,  " +
                        DATE + " VARCHAR(100) NULL  , " +
                        IMAGE_FOR_TEAM_A + " VARCHAR(100) NULL , " +
                        IMAGE_FOR_TEAM_B + " VARCHAR(100)  NULL , " +
                        STADIUM + " VARCHAR(100)   NULL   " +")";
                      //  FINISHED + " EXT CHECK( pType IN ('yes','no') ) NOT NULL DEFAULT  'no' "+")";

//        FINISHED + " EXT CHECK( pType IN ('yes','no') ) NOT NULL DEFAULT 'no')";
 //      sqLiteDatabase.execSQL (CREATE_TB_TEAMS);
      sqLiteDatabase.execSQL (CREATE_TB_MATCHES);


    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1) {
        throw new UnsupportedOperationException ("This shouldn't happen yet!");

    }

    public void addMathesList(String TeamA,String TeamB) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( TEAM_A, TeamA );
        values.put( TEAM_B, TeamB );
      /*  values.put( DATE, false );
        values.put( IMAGE_FOR_TEAM_A, false );
        values.put( IMAGE_FOR_TEAM_B, false );
        values.put( STADIUM, false );
        values.put( FINISHED, false );

*/

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
