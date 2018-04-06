package com.example.ibrahim.testworldcup.ui.matches;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.model.AllData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by ibrahim on 07/04/18.
 */

public class RVFirebaseHolders extends RecyclerView.ViewHolder{
    private static final String TAG = RVFirebaseHolders.class.getSimpleName();
    public ImageView markIcon;
    public TextView categoryTitle;
    public ImageView deleteIcon;
    private List<AllData> taskObject;
    public RVFirebaseHolders(final View itemView, final List<AllData> taskObject) {
        super(itemView);
        this.taskObject = taskObject;
        categoryTitle = (TextView)itemView.findViewById(R.id.TeamA);
       // markIcon = (ImageView)itemView.findViewById(R.id.TeamB);
        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Delete icon has been clicked", Toast.LENGTH_LONG).show();
                String taskTitle = taskObject.get(getAdapterPosition()).getTask ();
                Log.d(TAG, "AllData Title " + taskTitle);
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.orderByChild("groups").equalTo(taskTitle);
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener () {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled", databaseError.toException());
                    }
                });
            }
        });
    }
}