package com.example.mike.beasttutorial.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.entities.EventCard;
import com.example.mike.beasttutorial.entities.EventPicture;
import com.example.mike.beasttutorial.fragments.EventPhotoFragment;
import com.example.mike.beasttutorial.services.EventPhotoService;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mike on 4/15/2017.
 */

public class PhotoPagerActivity extends BaseActivity {

    private ArrayList<EventPicture> _eventPhotos;

    @BindView(R.id.activity_photo_viewPager)
    ViewPager viewPager;

    public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";

    public static Intent newIntent(Context context, EventCard eventCard)
    {
        Intent intent = new Intent(context, PhotoPagerActivity.class);
        intent.putExtra(EXTRA_CARD_INFO,eventCard.getEventId());
        return intent;
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_pager);
        ButterKnife.bind(this);
        _eventPhotos = new ArrayList<>();
        int cardIndex = getIntent().getIntExtra(EXTRA_CARD_INFO,0);
        switch(cardIndex)
        {
            case 1:
                bus.post(new EventPhotoService.SearchCommunityPhotoRequest("Hello"));
                break;
            case 3:
                bus.post(new EventPhotoService.SearchBrotherhoodPhotoRequest("Hello"));
                break;
            case 5:
                bus.post(new EventPhotoService.SearchSocialPhotoRequest("Hello"));
                break;
        }

        viewPager.setAdapter(new FragmentPagerAdapter( getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position)
            {
                {
                    EventPicture eventPicture = _eventPhotos.get(position);
                    return EventPhotoFragment.newInstance(eventPicture);
                }
            }

            @Override
            public int getCount() {
                return _eventPhotos.size();
            }
        });
    }

    @Subscribe
    public void getCommunityPhotos(EventPhotoService.SearchCommunityPhotoResponse response)
    {
        _eventPhotos.clear();
        _eventPhotos.addAll(response.communityPhotos);
    }

    @Subscribe
    public void getBrotherhoodPhotos(EventPhotoService.SearchBotherhoodPhotoResponse response)
    {
        _eventPhotos.clear();
        _eventPhotos.addAll(response.brotherhoodPhotos);
    }

    @Subscribe
    public void getSocialPhotos(EventPhotoService.SearchSocialPhotoResponse response)
    {
        _eventPhotos.clear();
        _eventPhotos.addAll(response.socialPhotos);
    }
}
