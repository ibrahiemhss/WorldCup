package com.example.ibrahim.testworldcup.Fragmnets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ibrahim.testworldcup.Adapters.StadiumsAdapter;
import com.example.ibrahim.testworldcup.Adapters.TeamAdapter;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.model.Stadiums;
import com.example.ibrahim.testworldcup.model.Teams;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TabFragmentLast  extends Fragment {
    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<Stadiums> list;
    RecyclerView recycle;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter  recyclerViewadapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_last, container, false);

        database = FirebaseDatabase.getInstance();
        myRef=database.getReference ();
        list=new ArrayList<> ();

        recycle = (RecyclerView)rootView. findViewById( R.id.RV_Test);
        recycle.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager (getActivity ());
        recycle.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewadapter = new StadiumsAdapter (list,getActivity () );

        myRef.child ("stadiums").addValueEventListener (new ValueEventListener () {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot :dataSnapshot.getChildren ()){
                    Stadiums stadiums=snapshot.getValue (Stadiums.class);
                    list.add (stadiums);
                    recycle.setAdapter(recyclerViewadapter);
                    recyclerViewadapter.notifyDataSetChanged ();


                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });



        return rootView;


    }
}