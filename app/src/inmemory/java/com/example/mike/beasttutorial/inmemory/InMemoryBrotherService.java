package com.example.mike.beasttutorial.inmemory;

import com.example.mike.beasttutorial.entities.Brother;
import com.example.mike.beasttutorial.infrastructure.BeastApplication;
import com.example.mike.beasttutorial.services.BrotherServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Mike on 1/1/2017.
 */

public class InMemoryBrotherService extends BaseInMemory {
    public InMemoryBrotherService(BeastApplication beastApplication) {
        super(beastApplication);
    }
    @Subscribe
    public void getBrothers(BrotherServices.SearchBrotherRequest request){
        BrotherServices.SearchBrotherResponse response = new BrotherServices.SearchBrotherResponse();
        response.brothers = new ArrayList<>();
        for(int i = 0; i < 32; i++)
        {
            response.brothers.add(new Brother(
                    i,
                    "Brother "+i,
                    "Reason for joining # "+i,
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Major " + i,
                    "Spring 201" + i,
                    "Fun Fact #" + i
            ));
        }

        bus.post(response);
    }
}
