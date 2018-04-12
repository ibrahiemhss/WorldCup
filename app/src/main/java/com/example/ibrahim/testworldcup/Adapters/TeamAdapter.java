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
import com.example.ibrahim.testworldcup.model.Teams;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ibrahim on 07/04/18.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyHoder> {
    List<Teams> list;
    Context context;

    AlertDialog.Builder builder;

    public TeamAdapter (List<Teams> list, Context context) {
        super();
        this.context=context;
        this.list=list;
    }


    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_item_team, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams( RecyclerView.LayoutParams.
                MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        TeamAdapter.MyHoder holder = new TeamAdapter.MyHoder (view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyHoder holder, int position) {
        final Teams SH = list.get(position);

        holder.teamName.setText(SH.getTeamName ().toString ());
       holder.groups.setText(SH.getGroups ());
//          holder.id.setText( String.valueOf(SH.getId ()));
           holder.score.setText( String.valueOf(SH.getScore ()));
     holder.win.setText( String.valueOf(SH.getWin ()));
     holder.played.setText( String.valueOf(SH.getPlayed ()));

     Picasso.get().load(SH.getImage ()).into(holder.image);

     holder.lose.setText( String.valueOf(SH.getLose ()));
     holder.goals.setText( String.valueOf(SH.getGoals ()));
 holder.draw.setText( String.valueOf(SH.getDraw ()));
    holder.active.setText(SH.getActive ());

     //
     //  holder.imagetext.setText(SH.getImage ());



    }

    @Override
    public int getItemCount()
    {
        if(list!=null){
            return list.size();

        }
        return 0 ;

    }

    class MyHoder extends RecyclerView.ViewHolder{

        TextView teamName,groups,id,score,win,played,lose,goals,draw,active,imagetext;
        ImageView image;


        public MyHoder(View itemView) {
            super(itemView);

 teamName = (TextView) itemView.findViewById(R.id.teamName);
            groups = (TextView) itemView.findViewById (R.id.groups);
     //       id = (TextView) itemView.findViewById (R.id.id);
            score = (TextView) itemView.findViewById (R.id.score);
            win = (TextView) itemView.findViewById (R.id.win);
            played = (TextView) itemView.findViewById (R.id.played);
            lose = (TextView) itemView.findViewById (R.id.lose);
            goals = (TextView) itemView.findViewById (R.id.goals);
            draw = (TextView) itemView.findViewById (R.id.draw);
            active = (TextView) itemView.findViewById (R.id.active);
            image = (ImageView) itemView.findViewById (R.id.list_image_team);


        }
    }

}

