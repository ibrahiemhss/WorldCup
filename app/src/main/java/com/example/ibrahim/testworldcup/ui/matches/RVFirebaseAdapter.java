package com.example.ibrahim.testworldcup.ui.matches;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.local.models.Matches;
import com.example.ibrahim.testworldcup.data.local.models.Teams;
import com.example.ibrahim.testworldcup.data.model.AllData;
import com.google.android.gms.tasks.Task;

import java.util.List;

/**
 * Created by ibrahim on 07/04/18.
 */

public class RVFirebaseAdapter   extends RecyclerView.Adapter<RVFirebaseAdapter.MyHoder> {
    List<Teams> list;
    Context context;

    AlertDialog.Builder builder;

    public RVFirebaseAdapter (List<Teams> list, Context context) {
        super();
        this.context=context;
        this.list=list;
    }


    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_item_teams, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams( RecyclerView.LayoutParams.
                MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        RVFirebaseAdapter.MyHoder holder = new RVFirebaseAdapter.MyHoder (view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyHoder holder, int position) {
        final Teams SH = list.get(position);

        holder.teamName.setText(SH.getTeamName ().toString ());
       holder.groups.setText(SH.getGroups ());
          holder.id.setText( String.valueOf(SH.getId ()));
           holder.score.setText( String.valueOf(SH.getScore ()));
        holder.imagetext.setText( String.valueOf(SH.getImageUri ()));

        holder.win.setText( String.valueOf(SH.getWin ()));
     holder.played.setText( String.valueOf(SH.getPlayed ()));


         Glide.with(context).load(SH.getImageUri ()).into(holder.image);




     holder.lose.setText( String.valueOf(SH.getLose ()));
     holder.goals.setText( String.valueOf(SH.getGoals ()));
 holder.draw.setText( String.valueOf(SH.getDraw ()));
    holder.active.setText(SH.getActive ());
    holder.image.setOnClickListener (new View.OnClickListener () {
        @Override
        public void onClick (View view) {
            Log.v("myImage",SH.getImageUri ());
            Toast.makeText (context,SH.getImageUri (),Toast.LENGTH_SHORT).show ();

        }
    });
     //
        // holder.image.setText(SH.getImage ());



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
            imagetext = (TextView) itemView.findViewById(R.id.imagetext);

            teamName = (TextView) itemView.findViewById(R.id.teamName);
            groups = (TextView) itemView.findViewById (R.id.groups);
            id = (TextView) itemView.findViewById (R.id.id);
            score = (TextView) itemView.findViewById (R.id.score);
            win = (TextView) itemView.findViewById (R.id.win);
            played = (TextView) itemView.findViewById (R.id.played);
            lose = (TextView) itemView.findViewById (R.id.lose);
            goals = (TextView) itemView.findViewById (R.id.goals);
            draw = (TextView) itemView.findViewById (R.id.draw);
            active = (TextView) itemView.findViewById (R.id.active);
            image = (ImageView) itemView.findViewById (R.id.image);


        }
    }

}

