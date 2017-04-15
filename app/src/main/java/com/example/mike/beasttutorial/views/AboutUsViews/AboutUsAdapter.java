package com.example.mike.beasttutorial.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.activities.BaseActivity;
import com.example.mike.beasttutorial.entities.EventCard;

import java.util.ArrayList;

/**
 * Created by Mike on 4/13/2017.
 */

public class AboutUsAdapter extends RecyclerView.Adapter{

    private final int VIEW_TYPE_MAIN_HEADER = 1;
    private final int VIEW_TYPE_SERVICE_LIST = 2;
    private final int VIEW_TYPE_BROTHERHOOD_LIST = 3;
    private final int VIEW_TYPE_SOCIAL_LIST = 4;
    private final int VIEW_TYPE_LIST_HEADER = 5;

    private LayoutInflater inflater;
    private BaseActivity activity;
    private ArrayList<EventCard> communityServiceEventCards;
    private ArrayList<EventCard> brotherhoodEventCards;
    private ArrayList<EventCard> socialEventCards;

    private AboutUsListener listener;

    public AboutUsAdapter(BaseActivity activity, AboutUsListener listener) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        communityServiceEventCards = new ArrayList<>();
        brotherhoodEventCards = new ArrayList<>();
        socialEventCards = new ArrayList<>();
    }

    public ArrayList<EventCard> getCommunityServiceEventCards() {
        return communityServiceEventCards;
    }

    public ArrayList<EventCard> getBrotherhoodEventCards() {
        return brotherhoodEventCards;
    }

    public ArrayList<EventCard> getSocialEventCards() {
        return socialEventCards;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return VIEW_TYPE_MAIN_HEADER;

        position --;

        if(communityServiceEventCards.size() > 0)
        {
            if(position == 0)
            {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;

            if (position<communityServiceEventCards.size())
            {
                return VIEW_TYPE_SERVICE_LIST;
            }
            position -= communityServiceEventCards.size();
        }

        if(brotherhoodEventCards.size()>0)
        {
            if (position == 0)
            {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;

            if(position < brotherhoodEventCards.size())
            {
                return VIEW_TYPE_BROTHERHOOD_LIST;
            }
            position -= brotherhoodEventCards.size();
        }

        if(socialEventCards.size()>0){
            if(position==0)
            {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;
        }

        if(position < socialEventCards.size())
        {
            return VIEW_TYPE_SOCIAL_LIST;
        }

        position-= socialEventCards.size();


        throw new IllegalArgumentException("We are being asked for a viewType at position" + position + "Although we are at the end of the adapter support viewholders. Please check your adapter" );
    }
    ///>>Header<<////




    //>>List Header<<//
    //>>Community List<<//


    //>>List Header<<//
    //>>Brotherhood List<<//


    //>>List Header<<//
    //>>Social List<<//




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eventCardView  = inflater.inflate(R.layout.list_event_card,parent,false);
        final View listHeader = inflater.inflate(R.layout.simple_header,parent,false);

        if(viewType== VIEW_TYPE_MAIN_HEADER)
        {
            return new AboutUsMainHeaderViewHolder(inflater,parent);
        }
        else if (viewType == VIEW_TYPE_SERVICE_LIST)
        {
            final CommunityServiceViewHolder communityServiceViewHolder = new CommunityServiceViewHolder(eventCardView);
            communityServiceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventCard eventCard = (EventCard) communityServiceViewHolder.itemView.getTag();
                    listener.OnEventCardClicked(eventCard);
                }
            });

            return communityServiceViewHolder;
        }
        else if (viewType == VIEW_TYPE_BROTHERHOOD_LIST)
        {
                final BrotherHoodViewHolder brotherHoodViewHolder = new BrotherHoodViewHolder(eventCardView);
                brotherHoodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          EventCard eventCard = (EventCard) brotherHoodViewHolder.itemView.getTag();
                          listener.OnEventCardClicked(eventCard);
                      }
                  }
                );
                return brotherHoodViewHolder;
        }
        else if (viewType == VIEW_TYPE_SOCIAL_LIST)
        {
            final SocialViewHolder socialViewHolder = new SocialViewHolder(eventCardView);
            socialViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventCard eventCard = (EventCard) socialViewHolder.itemView.getTag();
                    listener.OnEventCardClicked(eventCard);
                }
            });
            return socialViewHolder;
        }
        else if(viewType == VIEW_TYPE_LIST_HEADER)
        {
            return new AboutUsListHeaderViewHolder(listHeader);
        }

        throw new IllegalArgumentException(viewType + "Is not supported in this adapter");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AboutUsMainHeaderViewHolder)
        {
            AboutUsMainHeaderViewHolder holder1 = (AboutUsMainHeaderViewHolder) holder;
        }

        if(holder instanceof CommunityServiceViewHolder)
        {
            position--;
            if(communityServiceEventCards.size()>0)
            {
                position--;
            }
            EventCard eventCard = communityServiceEventCards.get(position);
            ((CommunityServiceViewHolder)holder).populate(activity,eventCard);
        }

        if(holder instanceof BrotherHoodViewHolder)
        {
            position--;
            if(communityServiceEventCards.size()>0)
            {
                position--;
                position-= communityServiceEventCards.size();
            }
            if(brotherhoodEventCards.size()>0)
            {
                position--;
            }
            EventCard eventCard = brotherhoodEventCards.get(position);
            ((BrotherHoodViewHolder) holder).populate(activity,eventCard);
        }

        if(holder instanceof SocialViewHolder){
            position--;
            if(communityServiceEventCards.size()>0)
            {
                position--;
                position-= communityServiceEventCards.size();
            }
            if(brotherhoodEventCards.size()>0)
            {
                position--;
                position-=brotherhoodEventCards.size();
            }
            if (socialEventCards.size()>0)
                position--;
            EventCard eventCard = socialEventCards.get(position);
            ((SocialViewHolder)holder).populate(activity,eventCard);
        }

        if(holder instanceof AboutUsListHeaderViewHolder)
        {
            AboutUsListHeaderViewHolder aboutUsListHeaderViewHolder = (AboutUsListHeaderViewHolder) holder;
            int servicePosition =1;
            int brotherhoodPosition = servicePosition + communityServiceEventCards.size()+1;
            int socialPosition = brotherhoodPosition + brotherhoodEventCards.size() + 1;

            if(position == servicePosition)
            {


                 aboutUsListHeaderViewHolder.populate("Community Service Events");
            }
            if(position == brotherhoodPosition)
            {
                aboutUsListHeaderViewHolder.populate("Brother Events");
            }
            if(position == socialPosition)
            {
                aboutUsListHeaderViewHolder.populate("Social Events");
            }





        }
    }

    @Override
    public int getItemCount() {
        int count = 1;
        if(communityServiceEventCards.size()>0)
            count += 1 + communityServiceEventCards.size();
        if(brotherhoodEventCards.size()>0)
            count += 1 + brotherhoodEventCards.size();
        if(socialEventCards.size()>0)
            count += 1 + socialEventCards.size();
        return count;
    }

    public interface AboutUsListener
    {
        void OnEventCardClicked(EventCard eventCard);
    }
}
