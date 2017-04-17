package com.example.mike.beasttutorial.views.RushViews;

import com.example.mike.beasttutorial.entities.RushEvent;

import java.util.List;

/**
 * Created by Mike on 4/16/2017.
 */

public class Item {
    public int type;
    public String header;
    public RushEvent rushEvent;
    public List<Item> invisibleChildren;

    public Item(int type, String header) {
        this.type = type;
        this.header = header;
    }

    public Item(int type, RushEvent rushEvent) {
        this.type = type;
        this.rushEvent = rushEvent;
    }
}
