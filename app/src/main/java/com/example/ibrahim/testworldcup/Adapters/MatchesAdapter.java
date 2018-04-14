package com.example.ibrahim.testworldcup.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        holder.away_team.setText(SH.getAway_team ());
       holder.home_team.setText(SH.getHome_team ());
        holder.away_result.setText(String.valueOf (SH.getAway_result ()));
        holder.home_result.setText(String.valueOf (SH.getHome_result ()));
        holder.date.setText(SH.getDate ());
        holder.stadium.setText(SH.getStadium ());
        //holder.finished.setText(SH.getAway_team ());
        //holder.type.setText(SH.getHome_team ());





/*        ShapeDrawable.ShaderFactory sf = new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                LinearGradient lg = new LinearGradient(0, 0, 0, holder.lineMatches.getHeight(),
                        new int[] {
                                Color.GRAY,
                                Color.WHITE,
                                Color.LTGRAY,
                                Color.DKGRAY }, //substitute the correct colors for these
                        new float[] {
                                0, 0.45f, 0.55f, 1 },
                        Shader.TileMode.REPEAT);

                return lg;
            }
        };
        PaintDrawable p = new PaintDrawable();
        p.setShape(new RectShape ());
        p.setShaderFactory(sf);
        p.setCornerRadius(70);*/
     //   holder.lineMatches.setBackground((Drawable)p);


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



        TextView away_team;
        TextView home_team;
        TextView date;
        TextView stadium;
        TextView away_result;
        TextView home_result;

        LinearLayout lin_result;

        MyHolder (View view) {
            super (view);
            away_team = (TextView) view.findViewById (R.id.away_team);
            home_team = (TextView) view.findViewById (R.id.home_team);
            date = (TextView) view.findViewById (R.id.date_m);
            stadium = (TextView) view.findViewById (R.id.stadium_m);
            away_result = (TextView) view.findViewById (R.id.away_result);
            home_result = (TextView) view.findViewById (R.id.home_result);

            lin_result = view.findViewById (R.id.lin_result);


        }

    } }