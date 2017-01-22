package com.example.mike.beasttutorial.inmemory;

import com.example.mike.beasttutorial.infrastructure.BeastApplication;

/**
 * Created by Mike on 1/1/2017.
 */

public class Module {
    public static void Register(BeastApplication application){
        new InMemoryBrotherService(application);
    }
}
