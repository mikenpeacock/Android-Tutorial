package com.example.mike.beasttutorial.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.activities.BaseActivity;
import com.example.mike.beasttutorial.entities.RushEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 4/16/2017.
 */

public class RushEventAdapter extends RecyclerView.Adapter {

    private List<Item> data;
    private BaseActivity activity;
    private LayoutInflater layoutInflater;
    private RushEventListener rushEventListener;
    public static final int VIEW_TYPE_LIST_HEADER = 1;
    public static final int VIEW_TYPE_EXPANDABLE_LIST_HEADER = 2;
    public static final int VIEW_TYPE_EXPANDABLE_LIST_CHILD = 3;
    public static final int VIEW_TYPE_LIST_FOOTER = 4;

    public RushEventAdapter(BaseActivity activity, RushEventListener rushEventListener) {
        this.activity = activity;
        this.rushEventListener = rushEventListener;
        layoutInflater = activity.getLayoutInflater();
        data = new ArrayList<>();
    }

    public List<Item> getData() {
        return data;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
        {
            return VIEW_TYPE_LIST_HEADER;
        }

        position--;

        if(position < data.size())
        {
            return data.get(position).type;
        }

        position -= data.size();

        if(position<data.size())
        {
            return VIEW_TYPE_LIST_FOOTER;
        }

        position--;

        throw new IllegalArgumentException("We are being asked for a viewType at position" + position + "Although we are at the end of the adapter support viewholders. Please check your adapter" );
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View expandableHeaderView = layoutInflater.inflate(R.layout.list_expandable_header,parent,false);
        View rushEventView = layoutInflater.inflate(R.layout.list_rush_event,parent,false);
        View rushHeaderView = layoutInflater.inflate(R.layout.header_fragment_rush,parent,false);
        View rushFooterView = layoutInflater.inflate(R.layout.footer_rush_fragment,parent,false);

        switch(viewType)
        {
            case VIEW_TYPE_LIST_HEADER:
                return new RushHeaderHolder(rushHeaderView);
            case VIEW_TYPE_EXPANDABLE_LIST_CHILD:
                final RushEventHolder holder = new RushEventHolder(rushEventView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        RushEvent rushEvent  = (RushEvent) holder.itemView.getTag();
                        rushEventListener.OnRushEventClicked(rushEvent);

                    }
                });
                return holder;
            case VIEW_TYPE_LIST_FOOTER:
                return new RushFooterHolder(rushFooterView);
            case VIEW_TYPE_EXPANDABLE_LIST_HEADER:
                return new RushExpandableHeaderHolder(expandableHeaderView);


        }
        throw new IllegalArgumentException(viewType + "Is not supported in this adapter");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //Header

        //List

        //Footer

        if(holder instanceof RushExpandableHeaderHolder)
        {
            position--;
            final Item item = data.get(position);
            final RushExpandableHeaderHolder itemController = (RushExpandableHeaderHolder) holder;
            itemController.referralItem = item;
            itemController.headerName.setText(item.header);
            if(item.invisibleChildren == null)
            {
                itemController.buttonToggle.setImageResource(R.mipmap.close);
            }
            else
            {
                itemController.buttonToggle.setImageResource(R.mipmap.plus);
            }
            itemController.backgroundView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(item.invisibleChildren == null)
                    {
                        item.invisibleChildren = new ArrayList<>();
                        int count  = 0;
                        int position = data.indexOf(itemController.referralItem);
                        while(data.size()>position+1 && data.get(position +1).type == VIEW_TYPE_EXPANDABLE_LIST_CHILD)
                        {
                            item.invisibleChildren.add(data.remove(position+1));
                            count++;
                        }
                        notifyItemRangeRemoved(position +1,count);
                        itemController.buttonToggle.setImageResource(R.mipmap.plus);
                    }
                    else
                    {
                        int position = data.indexOf(itemController.referralItem);
                        int index = position +1;
                        for(Item itemi: item.invisibleChildren)
                        {
                            data.add(index,itemi);
                            index++;
                        }
                        notifyItemRangeInserted(position + 1, index - position - 1);
                        itemController.buttonToggle.setImageResource(R.mipmap.close);
                        item.invisibleChildren = null;
                    }
                }
            });
        }
        else if (holder instanceof RushEventHolder)
        {
            position--;
            RushEventHolder holder1 = (RushEventHolder) holder;
            holder1.populate(data.get(position).rushEvent);
        }
        else if (holder instanceof RushHeaderHolder)
        {
            RushHeaderHolder holder1 = (RushHeaderHolder) holder;
        }
        else if (holder instanceof RushFooterHolder)
        {
            ((RushFooterHolder)holder).Populate(activity);
        }
    }

    @Override
    public int getItemCount()
    {
        int count = 2;
        if (data.size()>0)
        {
            count+=data.size();
        }
        return count;
    }

    public interface RushEventListener
    {
        void OnRushEventClicked(RushEvent rushEvent);
    }
}
