package com.example.mike.beasttutorial.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.entities.RushEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mike on 4/16/2017.
 */

public class RushEventHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_rush_event_name)
    TextView rushName;

    @BindView(R.id.list_rush_event_date)
    TextView rushDate;

    @BindView(R.id.list_rush_event_location)
    TextView rushLocation;

    @BindView(R.id.list_rush_event_time)
    TextView rushTime;

    public RushEventHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(RushEvent rushEvent)
    {
        itemView.setTag(rushEvent);
        rushName.setText(rushEvent.getEventName());
        rushDate.setText(rushEvent.getEventDate());
        rushLocation.setText(rushEvent.getEventLocation());
        rushTime.setText(rushEvent.getEventTime());
    }
}
