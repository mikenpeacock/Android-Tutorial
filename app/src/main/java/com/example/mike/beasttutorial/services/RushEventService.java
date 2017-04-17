package com.example.mike.beasttutorial.services;

import com.example.mike.beasttutorial.entities.RushEvent;

import java.util.List;

/**
 * Created by Mike on 4/17/2017.
 */

public class RushEventService {

    public RushEventService(){}

    public static class SearchRushEventCommunityRequest
    {
        public String fireBaseUrl;

        public SearchRushEventCommunityRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchRushEventCommunityResponce
    {
        public List<RushEvent> communityRushEvents;
    }

    public static class SearchRushEventSocialRequest
    {
        public String fireBaseUrl;

        public SearchRushEventSocialRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchRushEventSocialResponce
    {
        public List<RushEvent> socialEvents;
    }


}
