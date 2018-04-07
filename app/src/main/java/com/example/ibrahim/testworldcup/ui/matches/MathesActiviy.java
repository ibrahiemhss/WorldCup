package com.example.ibrahim.testworldcup.ui.matches;

import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.local.DBHelber;
import com.example.ibrahim.testworldcup.data.local.models.Matches;
import com.example.ibrahim.testworldcup.ui.main.MainActivity;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.ibrahim.testworldcup.data.model.AllData;
import com.google.firebase.database.ValueEventListener;

import static com.example.ibrahim.testworldcup.data.contract.FINISHED;
import static com.example.ibrahim.testworldcup.data.contract.IMAGE_FOR_TEAM_A;
import static com.example.ibrahim.testworldcup.data.contract.IMAGE_FOR_TEAM_B;
import static com.example.ibrahim.testworldcup.data.contract.STADIUM;
import static com.example.ibrahim.testworldcup.data.contract.TEAM_A;
import static com.example.ibrahim.testworldcup.data.contract.TEAM_B;

public class MathesActiviy extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<AllData> list;
    RecyclerView recycle;

    RecyclerView RV;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mathes_activiy);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("groups");

        myRef.addValueEventListener(new ValueEventListener () {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                list = new ArrayList<AllData>();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    AllData value = dataSnapshot1.getValue(AllData.class);
                    AllData fire = new AllData();
                    String name = value.getGroup ();
                    fire.setGroup (name);
                    list.add(fire);

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Hello", "Failed to read value.", error.toException());
            }

        });

        recycle = (RecyclerView) findViewById(R.id.RV_comming);

        RVFirebaseAdapter recyclerAdapter = new RVFirebaseAdapter(list,MathesActiviy.this);
        RecyclerView.LayoutManager recyce = new GridLayoutManager (MathesActiviy.this,2);
        /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
        // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recycle.setLayoutManager(recyce);
        recycle.setItemAnimator( new DefaultItemAnimator ());
        recycle.setAdapter(recyclerAdapter);


    }
/*

    private void displayOfline(){
        matches.clear();

        Cursor cursor = mDbHelber.getMatchesList( );
        while (cursor.moveToNext()) {
            Matches matches2;
            matches2 = new Matches(
                    cursor.getString( cursor.getColumnIndex( TEAM_A )),
                    cursor.getString( cursor.getColumnIndex( TEAM_B ) )
                */
/*    cursor.getString( cursor.getColumnIndex( DATE ))
                    cursor.getString( cursor.getColumnIndex( IMAGE_FOR_TEAM_A ) ),
                    cursor.getString( cursor.getColumnIndex( IMAGE_FOR_TEAM_B ) ),
                    cursor.getString( cursor.getColumnIndex( STADIUM ) ),
                    cursor.getString( cursor.getColumnIndex( FINISHED ))
                  *//*

            );
*/





}