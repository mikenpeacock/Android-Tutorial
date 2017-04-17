package com.example.mike.beasttutorial.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.activities.BaseActivity;
import com.example.mike.beasttutorial.entities.RushEvent;
import com.example.mike.beasttutorial.services.RushEventService;
import com.example.mike.beasttutorial.views.RushViews.Item;
import com.example.mike.beasttutorial.views.RushViews.RushEventAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 12/1/2016.
 */
public class RushFragment extends BaseFragment implements RushEventAdapter.RushEventListener {

    private RushEventAdapter adapter;
    private ArrayList<RushEvent> socialEvents;
    private ArrayList<RushEvent> communityEvents;

    private Item social;
    private Item community;
    private RecyclerView recyclerView;



    public static RushFragment newInstance()
    {
        return new RushFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragments_rush, container,false);
        adapter = new RushEventAdapter((BaseActivity)getActivity(),this);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_rush_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        socialEvents = new ArrayList<>();
        communityEvents = new ArrayList<>();

        List<Item> data = adapter.getData();

        social = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER, "Social Events");
        social.invisibleChildren = new ArrayList<>();

        community=  new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER, "Community Events");
        community.invisibleChildren = new ArrayList<>();

        bus.post(new RushEventService.SearchRushEventCommunityRequest("Hello"));
        bus.post(new RushEventService.SearchRushEventSocialRequest("Hello"));

        setUpAdapter();

        data.add(community);
        data.add(social);

        return rootView;
    }

    private void setUpAdapter()
    {
        if(isAdded())
        {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void OnRushEventClicked(RushEvent rushEvent) {

    }

    @Subscribe
    public void getServiceEvents(RushEventService.SearchRushEventCommunityResponce responce)
    {
        communityEvents.clear();
        communityEvents.addAll(responce.communityRushEvents);
        for(RushEvent rushEvent:communityEvents)
        {
            community.invisibleChildren.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD, rushEvent));
        }
    }

    @Subscribe
    public void getSocialEvents(RushEventService.SearchRushEventSocialResponce responce)
    {
        socialEvents.clear();
        socialEvents.addAll(responce.socialEvents);
        for(RushEvent rushEvent:socialEvents)
        {
            social.invisibleChildren.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD, rushEvent));
        }
    }
}
