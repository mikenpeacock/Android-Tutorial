package com.example.mike.beasttutorial.services;


import com.example.mike.beasttutorial.entities.EventPicture;

import java.util.List;

public class EventPhotoService {

    private EventPhotoService(){}

    public static class SearchCommunityPhotoRequest
    {
        public String fireBaseUrl;

        public SearchCommunityPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }


    public static class SearchCommunityPhotoResponse
    {
        public List<EventPicture> communityPhotos;
    }

    public static class SearchBrotherhoodPhotoRequest
    {
        public String fireBaseUrl;

        public SearchBrotherhoodPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBotherhoodPhotoResponse
    {
        public List<EventPicture> brotherhoodPhotos;
    }

    public static class SearchSocialPhotoRequest
    {
        public String fireBaseUrl;

        public SearchSocialPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchSocialPhotoResponse
    {
        public List<EventPicture> socialPhotos;
    }
}
