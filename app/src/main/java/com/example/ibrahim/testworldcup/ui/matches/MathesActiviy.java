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
import com.example.ibrahim.testworldcup.data.local.models.Teams;
import com.example.ibrahim.testworldcup.ui.main.MainActivity;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.ibrahim.testworldcup.data.model.AllData;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import static com.example.ibrahim.testworldcup.data.contract.FINISHED;
import static com.example.ibrahim.testworldcup.data.contract.IMAGE_FOR_TEAM_A;
import static com.example.ibrahim.testworldcup.data.contract.IMAGE_FOR_TEAM_B;
import static com.example.ibrahim.testworldcup.data.contract.STADIUM;
import static com.example.ibrahim.testworldcup.data.contract.TEAM_A;
import static com.example.ibrahim.testworldcup.data.contract.TEAM_B;

public class MathesActiviy extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<Teams> list;
    RecyclerView recycle;
    RVFirebaseAdapter recyclerAdapter;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter  recyclerViewadapter;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mathes_activiy);
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference ();
        list=new ArrayList<> ();

        recycle = (RecyclerView) findViewById( R.id.RV_comming);
        recycle.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager (this);
        recycle.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewadapter = new RVFirebaseAdapter (list,this );




        myRef.child ("teams").addValueEventListener (new ValueEventListener () {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot :dataSnapshot.getChildren ()){
                    Teams teams=snapshot.getValue (Teams.class);
                    list.add (teams);
                    recycle.setAdapter(recyclerViewadapter);
                    recyclerViewadapter.notifyDataSetChanged ();


                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });

    }

    public void pullOutTagsSuggestions(final String searchStr) {

        myRef.orderByChild("groups")
                .startAt(searchStr)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot != null) {

                            for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                                String suggestion = "" + suggestionSnapshot.child("RetailBranding").getValue();
                                Log.e("Hello", "suggestion -->" + suggestion);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
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