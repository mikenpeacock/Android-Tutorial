package com.example.mike.beasttutorial.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.beasttutorial.R;

/**
 * Created by Mike on 12/1/2016.
 */
public class RushFragment extends Fragment {


    public static RushFragment newInstance()
    {
        return new RushFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragments_rush, container,false);
        return rootView;
    }
}
