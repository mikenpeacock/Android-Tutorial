package com.example.mike.beasttutorial.views.RushViews;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mike.beasttutorial.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mike on 4/16/2017.
 */

public class RushFooterHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.footer_rush_fragment_facebook)
    ImageView facebookImage;

    @BindView(R.id.footer_rush_fragment_snapChat)
    ImageView snapchatImage;

    @BindView(R.id.footer_rush_fragment_twitter)
    ImageView twitterImage;

    @BindView(R.id.footer_rush_fragment_instagram)
    ImageView instagramImage;

    public RushFooterHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        facebookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try
                {
                    view.getContext().getPackageManager().getPackageInfo("com.facebook.katana",0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/508538279"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse(""));
                }
                view.getContext().startActivity(intent);
            }
        });

        twitterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try
                {
                    view.getContext().getPackageManager().getPackageInfo("com.twitter.android",0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id="+"57314553"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/TrishTreks?lang=en"));
                }
                view.getContext().startActivity(intent);
            }
        });

        instagramImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try
                {
                    view.getContext().getPackageManager().getPackageInfo("com.instagram.android",0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_u/trishtreks/"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/trishtreks/"));
                }
                view.getContext().startActivity(intent);
            }
        });

        snapchatImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try
                {
                    view.getContext().getPackageManager().getPackageInfo("com.snapchat.android",0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://snapchat.com/add/"+"tmmc88"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://snapchat.com/add/"+"tmmc88"));
                }
                view.getContext().startActivity(intent);
            }
        });
    }

    public void Populate(Context context)
    {
        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/faceBookLogo_zps5ehpqnng.png")
                .into(facebookImage);

        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/snapChat_logo_zpsjzwi8hpr.png")
                .into(snapchatImage);

        Picasso.with(context).load("https://s-media-cache-ak0.pinimg.com/736x/79/77/3f/79773f8cd180c79fcdc552cdbaf30ae6.jpg")
                .into(instagramImage);

        Picasso.with(context).load("https://dl.dropboxusercontent.com/s/jbtx0tbvi2t3v67/twitter%20logo.jpg?dl=0")
                .into(twitterImage);
    }
}

