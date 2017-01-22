package com.example.mike.beasttutorial.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.R2;
import com.example.mike.beasttutorial.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mike on 1/1/2017.
 */

public class BrotherDetailFragment extends BaseFragment {

    @BindView(R2.id.fragment_brother_detail_brother_crossed)
    TextView brotherCrossed;

    @BindView(R2.id.fragment_brother_detail_brother_fun_fact)
    TextView brotherFunFact;

    @BindView(R2.id.fragment_brother_detail_brother_major)
    TextView brotherMajor;

    @BindView(R2.id.fragment_brother_detail_brother_name)
    TextView brotherName;

    @BindView(R2.id.fragment_brother_detail_brother_picture)
    ImageView brotherImage;

    @BindView(R2.id.fragment_brother_detail_list_meet_a_bro_progressBar)
    ProgressBar brotherProgressBar;

    @BindView(R2.id.fragment_brother_detail_brother_why_joined)
    TextView brotherWhyJoined;

    private Brother brother;
    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";


    public static BrotherDetailFragment newInstance(Brother brother){
        Bundle arguments = new Bundle();
        arguments.putParcelable(BROTHER_EXTRA_INFO,brother);
        BrotherDetailFragment brotherDetailFragment = new BrotherDetailFragment();
        brotherDetailFragment.setArguments(arguments);
        return brotherDetailFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brother = getArguments().getParcelable(BROTHER_EXTRA_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_brother_details,container,false);
        ButterKnife.bind(this,rootView);
        brotherName.setText(brother.getBrotherName());
        brotherMajor.setText(getString(R.string.major_intro,brother.getBrotherMajor()));
        brotherFunFact.setText(getString(R.string.fun_fact_intro,brother.getBrotherFunFact()));
        brotherCrossed.setText(getString(R.string.fun_fact_intro,brother.getBrotherCrossSemester()));
        brotherWhyJoined.setText(brother.getBrotherWhyJoin());
        Picasso.with(getActivity()).load(brother.getBrotherPic())
        .fit()
        .centerCrop()
        .into(brotherImage, new Callback() {
            @Override
            public void onSuccess() {
                brotherProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
        return rootView;
    }


}
