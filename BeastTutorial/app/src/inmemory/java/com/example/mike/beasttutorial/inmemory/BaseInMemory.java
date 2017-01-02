package com.example.mike.beasttutorial.inmemory;

import com.example.mike.beasttutorial.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

/**
 * Created by Mike on 1/1/2017.
 */

public class BaseInMemory {
    protected final Bus bus;
    protected final BeastApplication beastApplication;

    public BaseInMemory(BeastApplication beastApplication) {
        this.beastApplication = beastApplication;
        this.bus = beastApplication.getBus();
        bus.register(this);
    }
}
