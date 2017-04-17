package com.example.mike.beasttutorial.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.beasttutorial.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mike on 4/16/2017.
 */

public class RushExpandableHeaderHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_expandable_header_buttonToggle)
    ImageView buttonToggle;

    @BindView(R.id.list_expandable_header_layout)
    View backgroundView;

    @BindView(R.id.list_expandable_header_headerName)
    TextView headerName;

    public Item referralItem;



    public RushExpandableHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
