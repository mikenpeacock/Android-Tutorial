package com.example.mike.beasttutorial.views.MeetABroViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.mike.beasttutorial.R2;
import com.example.mike.beasttutorial.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mike on 12/19/2016.
 */

public class MeetABroViewHolder extends RecyclerView.ViewHolder {
    @BindView(R2.id.list_meet_a_bro_imageView)
    ImageView brotherPic;

    @BindView(R2.id.list_meet_a_bro_progressBar)
    ProgressBar brotherProgressBar;


    public MeetABroViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, Brother brother){
        itemView.setTag(brother);
        Picasso.with(context).load(brother.getBrotherPic())
                .fit()
                .centerCrop()
                .into(brotherPic, new Callback() {
                    @Override
                    public void onSuccess() {
                        brotherProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
