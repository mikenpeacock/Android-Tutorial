package com.example.mike.beasttutorial.services;

import com.example.mike.beasttutorial.entities.EventCard;

import java.util.List;

/**
 * Created by Mike on 4/13/2017.
 */

public class EventCardService {

    private EventCardService(){}
    public static class SearchCommunitySericeCardRequest
    {
        public String fireBaseUrl;

        public SearchCommunitySericeCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCommunityServiceCardsResponse
    {
        public List<EventCard> communityServiceCards;
    }

    public static class SearchBrotherhoodCardCardRequest
    {
        public String fireBaseUrl;

        public SearchBrotherhoodCardCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherhoodCardCardResponce
    {
        public List<EventCard> brotherhooodCards;
    }

    public static class SearchSocialCardRequest
    {
        public String fireBaseUrl;

        public SearchSocialCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchSocialCardResponce
    {
        public List<EventCard> socialCards;
    }
}
