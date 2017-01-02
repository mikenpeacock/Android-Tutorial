package com.example.mike.beasttutorial.services;

import com.example.mike.beasttutorial.entities.Brother;

import java.util.List;

/**
 * Created by Mike on 1/1/2017.
 */

public class BrotherServices {
    public BrotherServices() {
    }

    public static class SearchBrotherRequest{
        public String fireBaseUrl;

        public SearchBrotherRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherResponse {
        public List<Brother> brothers;
    }
}
