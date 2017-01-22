package com.example.mike.beasttutorial.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.R2;
import com.example.mike.beasttutorial.entities.Brother;
import com.example.mike.beasttutorial.fragments.BrotherDetailFragment;
import com.example.mike.beasttutorial.services.BrotherServices;
import com.squareup.otto.Subscribe;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mike on 1/2/2017.
 */

public class BrotherPagerActivity extends BaseActivity {
    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";
    private ArrayList<Brother> brothers;

    @BindView(R2.id.activity_brother_viewPager)
    ViewPager brotherViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brother_pager);
        ButterKnife.bind(this);
        brothers = new ArrayList<>();
        bus.post(new BrotherServices.SearchBrotherRequest("Hello"));
        brotherViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager())
        {

            @Override
            public Fragment getItem(int position) {
                Brother brother = brothers.get(position);
                return BrotherDetailFragment.newInstance(brother);
            }

            @Override
            public int getCount() {
                return brothers.size();
            }
        });

        Brother brother = getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
        int brotherId = brother.getBrotherId();
        for(int i = 0;i < brothers.size();i++)
        {
            if(brothers.get(i).getBrotherId() == brotherId){
                brotherViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Subscribe
    public void getBrothers(BrotherServices.SearchBrotherResponse response)
    {
        brothers.clear();
        brothers.addAll(response.brothers);
    }

    public static Intent newIntent(Context context, Brother brother)
    {
        Intent intent = new Intent(context,BrotherPagerActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO,brother);
        return intent;
    }
}
