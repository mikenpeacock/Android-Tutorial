package com.example.mike.beasttutorial.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.mike.beasttutorial.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

/**
 * Created by Mike on 1/1/2017.
 */

public class BaseFragment extends Fragment {


    protected Bus bus;
    private BeastApplication application;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BeastApplication) getActivity().getApplication();
        bus = application.getBus();
        bus.register(this);
    }
}
