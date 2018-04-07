package com.example.ibrahim.testworldcup.ui.matches;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.model.AllData;
import com.google.android.gms.tasks.Task;

import java.util.List;

/**
 * Created by ibrahim on 07/04/18.
 */

public class RVFirebaseAdapter   extends RecyclerView.Adapter<RVFirebaseAdapter.MyHoder> {
    List<AllData> list;
    Context context;

    public RVFirebaseAdapter(List<AllData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_matches,parent,false);
        MyHoder myHoder = new MyHoder(view);


        return myHoder;
    }

    @Override
    public void onBindViewHolder(MyHoder holder, int position) {
        AllData mylist = list.get(position);
        holder.TeamA.setText(mylist.getGroup ());

    }

    @Override
    public int getItemCount() {

        int arr = 0;

        try{
            if(list.size()==0){

                arr = 0;

            }
            else{

                arr=list.size();
            }



        }catch (Exception e){



        }

        return arr;

    }

    class MyHoder extends RecyclerView.ViewHolder{
        TextView TeamA;



        public MyHoder(View itemView) {
            super(itemView);
            TeamA = (TextView) itemView.findViewById(R.id.TeamA);

        }
    }

}

