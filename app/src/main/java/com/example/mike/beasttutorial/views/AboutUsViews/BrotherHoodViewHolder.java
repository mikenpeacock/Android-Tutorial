package com.example.mike.beasttutorial.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.entities.EventCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mike on 4/13/2017.
 */

public class BrotherHoodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_event_card_eventDescription)
    TextView eventDescriptoin;

    @BindView(R.id.list_event_card_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.list_event_card_imageView)
    ImageView eventImage;

    @BindView(R.id.list_event_card_eventType)
    ImageView eventType;

    @BindView(R.id.list_event_card_eventName)
    TextView eventName;


    public BrotherHoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, EventCard eventCard)
    {
        itemView.setTag(eventCard);

        if(!eventCard.isVideo())
        {
            eventType.setImageResource(R.mipmap.camera);
        }
        else
        {
            eventType.setImageResource(R.mipmap.video);
        }

        eventDescriptoin.setText(eventCard.getEventDescription());
        eventName.setText(eventCard.getEventName());

        Picasso.with(context).load(eventCard.getEventImage())
                .fit()
                .centerCrop()
                .into(eventImage, new Callback()
                {
                    @Override
                    public void onSuccess()
                    {
                        progressBar.setVisibility(View.GONE);
                    }
                    @Override
                    public void onError()
                    {

                    }
                });
    }
}
