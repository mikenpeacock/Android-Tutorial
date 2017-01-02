package com.example.mike.beasttutorial.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.entities.Brother;
import com.example.mike.beasttutorial.fragments.BrotherDetailFragment;

/**
 * Created by Mike on 1/1/2017.
 */

public class PracticeActivity extends BaseActivity {

    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_practice_fragment_container);
        if(fragment == null)
        {
            fragment =null;
            fragmentManager.beginTransaction()
                    .add(R.id.activity_practice_fragment_container,fragment)
                    .commit();
        }
    }

    public static Intent newItent(Context context, Brother brother){
        Intent intent = new Intent(context, PracticeActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO,brother);
        return intent;
    }
}
