package com.example.ibrahim.testworldcup.ui.matches;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.model.AllData;
import com.google.android.gms.tasks.Task;

import java.util.List;

/**
 * Created by ibrahim on 07/04/18.
 */

public class RVFirebaseAdapter   extends RecyclerView.Adapter<RVFirebaseHolders> {
    private List<AllData> task;
    protected Context context;
    public RVFirebaseAdapter(Context context, List<AllData> task) {
        this.task = task;
        this.context = context;
    }
    @Override
    public RVFirebaseHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        RVFirebaseHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_matches, parent, false);
        viewHolder = new RVFirebaseHolders(layoutView, task);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RVFirebaseHolders holder, int position) {
        holder.categoryTitle.setText(task.get(position).getTask());
    }
    @Override
    public int getItemCount() {
        return this.task.size();
    }
}