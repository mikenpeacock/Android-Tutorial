package com.example.mike.beasttutorial.inmemory;

import com.example.mike.beasttutorial.entities.RushEvent;
import com.example.mike.beasttutorial.infrastructure.BeastApplication;
import com.example.mike.beasttutorial.services.RushEventService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Mike on 4/17/2017.
 */

public class InMemoryRushEventService extends BaseInMemory{

    public InMemoryRushEventService(BeastApplication beastApplication) {
        super(beastApplication);
    }

    @Subscribe
    public void getCommunityRushEvents(RushEventService.SearchRushEventCommunityRequest request)
    {
        RushEventService.SearchRushEventCommunityResponce responce = new RushEventService.SearchRushEventCommunityResponce();
        responce.communityRushEvents = new ArrayList<>();
        responce.communityRushEvents.add(new RushEvent(
                1,
                "Rush Community Event 1"
                ,"9/05/2017"
                ,"8:00pm"
                ,"EN1001"
                ,2.2
                ,2.2
                ,true
                ,"This is where the description of the event goes!"
        ));

        bus.post(responce);
    }


    @Subscribe
    public void getSocialRushEvents(RushEventService.SearchRushEventCommunityRequest request)
    {
        RushEventService.SearchRushEventSocialResponce responce = new RushEventService.SearchRushEventSocialResponce();
        responce.socialEvents = new ArrayList<>();
        responce.socialEvents.add(new RushEvent(
                1,
                "Rush Social Event 1"
                ,"9/05/2017"
                ,"8:00pm"
                ,"230 Elizabeth Ave, St. John's, NL A1B 3X9"
                ,47.571115//lat
                ,-52.732782//lon
                ,true
                ,"This is where the description of the event goes!"
        ));

        bus.post(responce);
    }
}
