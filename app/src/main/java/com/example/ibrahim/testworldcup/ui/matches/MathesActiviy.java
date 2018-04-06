package com.example.ibrahim.testworldcup.ui.matches;

import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

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
import static com.example.ibrahim.testworldcup.data.contract.FINISHED;
import static com.example.ibrahim.testworldcup.data.contract.IMAGE_FOR_TEAM_A;
import static com.example.ibrahim.testworldcup.data.contract.IMAGE_FOR_TEAM_B;
import static com.example.ibrahim.testworldcup.data.contract.STADIUM;
import static com.example.ibrahim.testworldcup.data.contract.TEAM_A;
import static com.example.ibrahim.testworldcup.data.contract.TEAM_B;

public class MathesActiviy extends AppCompatActivity {
    private List<Matches> matches ;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter  recyclerViewadapter;
    DBHelber mDbHelber;
    private DatabaseReference databaseReference;
    private List<AllData> allTask;

    RecyclerView RV;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mathes_activiy);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        allTask = new ArrayList<AllData>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDbHelber=new DBHelber( this );
        matches=new ArrayList<> ();
        RV = (RecyclerView) findViewById( R.id.RV_comming);
        RV.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager (this );
        RV.setLayoutManager(recyclerViewlayoutManager);
     ////   recyclerViewadapter = new RVFirebaseAdapter (allTask,this );
    //    RV.setAdapter(recyclerViewadapter);
    //    recyclerViewadapter.notifyDataSetChanged();
        databaseReference.addChildEventListener(new ChildEventListener () {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getAllTask(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getAllTask(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
             //   taskDeletion(dataSnapshot);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        displayOfline();

/*TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
       tabLayout.addTab(tabLayout.newTab().setText("Comming Mathes"));
     tabLayout.addTab(tabLayout.newTab().setText("Today Mathes"));
        tabLayout.addTab(tabLayout.newTab().setText("Last Mathes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }
    private void getAllTask(DataSnapshot dataSnapshot){
        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            String taskTitle = singleSnapshot.getValue(String.class);
            allTask.add(new AllData(taskTitle));
            recyclerViewadapter = new RVFirebaseAdapter(MathesActiviy.this, allTask);
            RV.setAdapter(recyclerViewadapter);
        }
    }
    private void displayOfline(){
        matches.clear();

        Cursor cursor = mDbHelber.getMatchesList( );
        while (cursor.moveToNext()) {
            Matches matches2;
            matches2 = new Matches(
                    cursor.getString( cursor.getColumnIndex( TEAM_A )),
                    cursor.getString( cursor.getColumnIndex( TEAM_B ) )
                /*    cursor.getString( cursor.getColumnIndex( DATE ))
                    cursor.getString( cursor.getColumnIndex( IMAGE_FOR_TEAM_A ) ),
                    cursor.getString( cursor.getColumnIndex( IMAGE_FOR_TEAM_B ) ),
                    cursor.getString( cursor.getColumnIndex( STADIUM ) ),
                    cursor.getString( cursor.getColumnIndex( FINISHED ))
                  */
            );


            matches.add( matches2 );

        }}
}