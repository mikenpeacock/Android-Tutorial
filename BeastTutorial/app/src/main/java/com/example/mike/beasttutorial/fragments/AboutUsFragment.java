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
public class AboutUsFragment extends BaseFragment{

    public static AboutUsFragment newInstance()
    {
        return new AboutUsFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us, container,false);
        return rootView;
    }
}
