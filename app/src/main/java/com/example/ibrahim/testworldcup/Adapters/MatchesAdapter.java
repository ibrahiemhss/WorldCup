package com.example.ibrahim.testworldcup.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.model.Matches;

import java.util.List;

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
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_matches, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams( RecyclerView.LayoutParams.
                MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        final Matches SH = matches.get(position);

        holder.TeamA.setText(SH.getTeamA ());
//        holder.TeamB.setText(SH.getTeamB ());
   //     holder.image_for_teamA.setText(SH.getImage_for_teamA ());
  //      holder.image_for_teamB.setText(SH.getImage_for_teamB ());
//        holder.date.setText(SH.getDate ());
   //     holder.stadium.setText(SH.getStadium ());

//        holder.user_id.setText(SH.getUser_id());
     //   holder.car_id.setText(SH.getCar_id());


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



        TextView TeamA;
        TextView TeamB;
        ImageView image_for_teamA;
        ImageView image_for_teamB;
        TextView date;
        TextView stadium;
        TextView finished;

        MyHolder (View view) {
            super (view);
            TeamA = (TextView) view.findViewById (R.id.TeamA);
            //TeamB = (TextView) view.findViewById (R.id.TeamB);
           // date = (TextView) view.findViewById (R.id.date);
         //   image_for_teamA = (ImageView) view.findViewById (R.id.image_for_teamA);
         //   image_for_teamB = (ImageView) view.findViewById (R.id.image_for_teamB);
        //    stadium = (TextView) view.findViewById (R.id.stadium);


        }

    } }