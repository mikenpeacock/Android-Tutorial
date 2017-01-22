package com.example.mike.beasttutorial.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.activities.BaseActivity;
import com.example.mike.beasttutorial.activities.BrotherPagerActivity;
import com.example.mike.beasttutorial.activities.PracticeActivity;
import com.example.mike.beasttutorial.entities.Brother;
import com.example.mike.beasttutorial.services.BrotherServices;
import com.example.mike.beasttutorial.views.MeetABroViews.MeetABroAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Mike on 12/1/2016.
 */
public class MeetABroFragment extends BaseFragment implements MeetABroAdapter.OnBrotherClicked{

    private final String LOG_TAG = MeetABroFragment.class.getSimpleName();
    private MeetABroAdapter aBroAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Brother> brothers;

    public static MeetABroFragment newInstance()
    {
        return new MeetABroFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meet_a_bro, container,false);
        aBroAdapter = new MeetABroAdapter((BaseActivity) getActivity(),this);
        brothers = aBroAdapter.getBrothers();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_meet_a_bro_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
        setUpAdapter();
        bus.post(new BrotherServices.SearchBrotherRequest("Hello"));
        return rootView;
    }

    private void setUpAdapter()
    {        if(isAdded())
        {
            recyclerView.setAdapter(aBroAdapter);
        }
    }

    @Override
    public void OnBrotherClicked(Brother brother) {
        Intent intent = BrotherPagerActivity.newIntent(getActivity(),brother);
        startActivity(intent);
    }

    @Subscribe
    public void getBrothers(BrotherServices.SearchBrotherResponse response){
        brothers.clear();
        brothers.addAll(response.brothers);

    }


}
