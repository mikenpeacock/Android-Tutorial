package com.example.mike.beasttutorial.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.activities.BaseActivity;
import com.example.mike.beasttutorial.activities.PhotoPagerActivity;
import com.example.mike.beasttutorial.activities.YoutubeActivity;
import com.example.mike.beasttutorial.entities.EventCard;
import com.example.mike.beasttutorial.services.EventCardService;
import com.example.mike.beasttutorial.views.AboutUsViews.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Mike on 12/1/2016.
 */
public class AboutUsFragment extends BaseFragment implements AboutUsAdapter.AboutUsListener{

    private ArrayList<EventCard> serviceCards;
    private ArrayList<EventCard> brotherhoodCards;
    private ArrayList<EventCard> socialCards;

    private RecyclerView recyclerView;
    private AboutUsAdapter aboutUsAdapter;

    public static AboutUsFragment newInstance()
    {
        return new AboutUsFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us, container,false);
        aboutUsAdapter = new AboutUsAdapter((BaseActivity)getActivity(),this);
        serviceCards = aboutUsAdapter.getCommunityServiceEventCards();
        brotherhoodCards = aboutUsAdapter.getBrotherhoodEventCards();
        socialCards = aboutUsAdapter.getSocialEventCards();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_about_us_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        setUpAdapter();
        bus.post(new EventCardService.SearchCommunitySericeCardRequest("Hello"));
        bus.post(new EventCardService.SearchBrotherhoodCardCardRequest("Hello"));
        bus.post(new EventCardService.SearchSocialCardRequest("Hello"));

        return rootView;
    }

    private void setUpAdapter()
    {
        if(isAdded())
        {
          recyclerView.setAdapter(aboutUsAdapter);
        }
    }

    @Override
    public void OnEventCardClicked(EventCard eventCard) {
        if(!eventCard.isVideo())
        {
           Intent intent = PhotoPagerActivity.newIntent(getActivity(),eventCard);
            startActivity(intent);
        }
        else
        {
            Intent intent  = YoutubeActivity.newIntent(getActivity(),eventCard);
            startActivity(intent);
        }

    }

    @Subscribe
    public void getCommunityServiceEvents(EventCardService.SearchCommunityServiceCardsResponse responce)
    {
        serviceCards.clear();
        serviceCards.addAll(responce.communityServiceCards);
    }

    @Subscribe
    public void getBrotherhoodEvents(EventCardService.SearchBrotherhoodCardCardResponce responce)
    {
        brotherhoodCards.clear();
        brotherhoodCards.addAll(responce.brotherhooodCards);
    }

    @Subscribe
    public void getSocialEvents(EventCardService.SearchSocialCardResponce responce)
    {
        socialCards.clear();
        socialCards.addAll(responce.socialCards);
    }
}
