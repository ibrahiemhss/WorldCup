package com.example.ibrahim.testworldcup.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.dialoges.Location;
import com.example.ibrahim.testworldcup.model.Matches;
import com.example.ibrahim.testworldcup.ui.MainActivity;
import com.example.ibrahim.testworldcup.ui.MatchesActiviy;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 28/06/2017.
 */

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MyHolder> {

    List<Matches> matches;
    Context context;
    AlertDialog.Builder builder;

    public MatchesAdapter (List<Matches> matches, Context context) {
        super();
        this.context=context;
        this.matches=matches;
    }



    /* public CommentAdapter(List<ListComments> mylist) {
     }
 */


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_item_main, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams( RecyclerView.LayoutParams.
                MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        final Matches SH = matches.get(position);

        holder.away_team.setText(SH.getAway_team ());
       holder.home_team.setText(SH.getHome_team ());
  //      holder.away_result.setText(String.valueOf (SH.getAway_result ()));
    //    holder.home_result.setText(String.valueOf (SH.getHome_result ()));
        holder.date.setText(SH.getDate ());
        holder.stadium.setText(SH.getCity ());
        //holder.finished.setText(SH.getAway_team ());
        //holder.type.setText(SH.getHome_team ());
        Picasso.get().load(SH.getHome_team_flag ()).into(holder.home_team_flag);
        Picasso.get().load(SH.getAway_team_flag ()).into(holder.away_team_flag);

        holder.matche_location.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent (context, Location.class);
                String strName = null;
                intent.putExtra("latitude", SH.getLat ());
                intent.putExtra("longitude", SH.getLng ());
                intent.putExtra("city", SH.getCity ());

                context.startActivity (intent);
            }
        });

    }
    @Override
    public int getItemCount()
    {
        if(matches!=null){
            return matches.size();

        }
        return 0 ;

    }



    public class MyHolder extends RecyclerView.ViewHolder {



    private     TextView away_team;
        private TextView home_team;
      private   TextView date;
       private TextView stadium;
       private TextView away_result;
        private TextView home_result;
        private CircleImageView home_team_flag,away_team_flag;

       private LinearLayout lin_result,matche_location;

        MyHolder (View view) {
            super (view);
            away_team = (TextView) view.findViewById (R.id.away_team);
            home_team = (TextView) view.findViewById (R.id.home_team);
            date = (TextView) view.findViewById (R.id.date_m);
            stadium = (TextView) view.findViewById (R.id.stadium_m);
            away_result = (TextView) view.findViewById (R.id.away_result);
            home_result = (TextView) view.findViewById (R.id.home_result);
            home_team_flag = view.findViewById (R.id.home_team_flag);
            away_team_flag = view.findViewById (R.id.away_team_flag);
            matche_location = view.findViewById (R.id.matche_location);

            lin_result = view.findViewById (R.id.lin_result);


        }

    } }