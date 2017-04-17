package com.example.mike.beasttutorial.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mike on 4/15/2017.
 */

public class RushEvent implements Parcelable {

    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private double eventLatitude;
    private double eventLongitude;
    private boolean isOnCampus;
    private String eventDescription;

    public RushEvent(int eventId, String eventName, String eventDate, String eventTime, String eventLocation, double eventLatitude, double eventLongitude, boolean isOnCampus, String eventDescription) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.eventLatitude = eventLatitude;
        this.eventLongitude = eventLongitude;
        this.isOnCampus = isOnCampus;
        this.eventDescription = eventDescription;
    }

    protected RushEvent(Parcel in) {
        eventId = in.readInt();
        eventName = in.readString();
        eventDate = in.readString();
        eventTime = in.readString();
        eventLocation = in.readString();
        eventLatitude = in.readDouble();
        eventLongitude = in.readDouble();
        isOnCampus = in.readByte() != 0;
        eventDescription = in.readString();
    }

    public static final Creator<RushEvent> CREATOR = new Creator<RushEvent>() {
        @Override
        public RushEvent createFromParcel(Parcel in) {
            return new RushEvent(in);
        }

        @Override
        public RushEvent[] newArray(int size) {
            return new RushEvent[size];
        }
    };

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public double getEventLatitude() {
        return eventLatitude;
    }

    public double getEventLongitude() {
        return eventLongitude;
    }

    public boolean isOnCampus() {
        return isOnCampus;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(eventId);
        dest.writeString(eventName);
        dest.writeString(eventDate);
        dest.writeString(eventTime);
        dest.writeString(eventLocation);
        dest.writeDouble(eventLatitude);
        dest.writeDouble(eventLongitude);
        dest.writeByte((byte) (isOnCampus ? 1 : 0));
        dest.writeString(eventDescription);
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
