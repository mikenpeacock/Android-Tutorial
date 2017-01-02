package com.example.mike.beasttutorial.views.MeetABroViews;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.activities.BaseActivity;
import com.example.mike.beasttutorial.entities.Brother;

import java.util.ArrayList;

/**
 * Created by Mike on 12/19/2016.
 */

public class MeetABroAdapter extends RecyclerView.Adapter<MeetABroViewHolder> implements View.OnClickListener {

    private LayoutInflater inflator;
    private BaseActivity activity;
    private OnBrotherClicked listener;
    private ArrayList<Brother> brothers;

    public MeetABroAdapter(BaseActivity activity, OnBrotherClicked listener) {
        this.activity = activity;
        this.listener = listener;
        inflator = activity.getLayoutInflater();
        brothers = new ArrayList<>();
    }

    public ArrayList<Brother> getBrothers() {
        return brothers;
    }

    public void setBrothers(ArrayList<Brother> brothers) {
        this.brothers = brothers;
    }

    @Override
    public MeetABroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listView = inflator.inflate(R.layout.list_meet_a_bro,parent,false);
        listView.setOnClickListener(this);
        return new MeetABroViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(MeetABroViewHolder holder, int position) {
        holder.populate(activity,brothers.get(position));

    }

    @Override
    public int getItemCount() {
        return brothers.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag() instanceof Brother)
        {
            Brother brother = (Brother) view.getTag();
            listener.OnBrotherClicked(brother);
        }

    }
    public interface OnBrotherClicked{
        void OnBrotherClicked(Brother brother);
    }
}

