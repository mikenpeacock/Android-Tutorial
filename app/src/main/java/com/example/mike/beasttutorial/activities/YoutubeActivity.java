package com.example.mike.beasttutorial.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.mike.beasttutorial.R;
import com.example.mike.beasttutorial.entities.EventCard;
import com.example.mike.beasttutorial.infrastructure.BeastApplication;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Mike on 4/15/2017.
 */

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    private String _videoUrl;
    public static final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youtube);
        _videoUrl = getIntent().getStringExtra(EXTRA_VIDEO_INFO);
        YouTubePlayerView youtubePlayerView = (YouTubePlayerView) findViewById(R.id.activity_youtube_player_view);
        youtubePlayerView.initialize(BeastApplication.YOUTUBE_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(_videoUrl);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    public static Intent newIntent(Context context, EventCard eventCard)
    {
        Intent intent = new Intent(context, YoutubeActivity.class);
        intent.putExtra(EXTRA_VIDEO_INFO,eventCard.getYoutubeEnding());
        return intent;
    }
}
