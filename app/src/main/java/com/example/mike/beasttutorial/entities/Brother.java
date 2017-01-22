package com.example.mike.beasttutorial.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mike on 12/19/2016.
 */

public class Brother implements Parcelable {

    private int brotherId;
    private String brotherName;
    private String brotherWhyJoin;
    private String brotherPic;
    private String brotherMajor;
    private String brotherCrossSemester;
    private String brotherFunFact;


    public Brother(int brotherId, String brotherName, String brotherWhyJoin,
                   String brotherPic, String brotherMajor,
                   String brotherCrossSemester, String brotherFunFact)
    {

        this.brotherId = brotherId;
        this.brotherName = brotherName;
        this.brotherWhyJoin = brotherWhyJoin;
        this.brotherPic = brotherPic;
        this.brotherMajor = brotherMajor;
        this.brotherCrossSemester = brotherCrossSemester;
        this.brotherFunFact = brotherFunFact;
    }

    protected Brother(Parcel in)
    {
        brotherId = in.readInt();
        brotherName = in.readString();
        brotherWhyJoin = in.readString();
        brotherPic = in.readString();
        brotherMajor = in.readString();;
        brotherCrossSemester = in.readString();
        brotherFunFact = in.readString();
    }


    public static final Creator<Brother> CREATOR = new Creator<Brother>() {
        @Override
        public Brother createFromParcel(Parcel in) {
            return new Brother(in);
        }

        @Override
        public Brother[] newArray(int size) {
            return new Brother[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(brotherId);
        dest.writeString(brotherName);
        dest.writeString(brotherWhyJoin);
        dest.writeString(brotherPic);
        dest.writeString(brotherMajor);
        dest.writeString(brotherCrossSemester);
        dest.writeString(brotherFunFact);
    }

    public int getBrotherId() {
        return brotherId;
    }

    public void setBrotherId(int brotherId) {
        this.brotherId = brotherId;
    }

    public String getBrotherName() {
        return brotherName;
    }

    public void setBrotherName(String brotherName) {
        this.brotherName = brotherName;
    }

    public String getBrotherWhyJoin() {
        return brotherWhyJoin;
    }

    public void setBrotherWhyJoin(String brotherWhyJoin) {
        this.brotherWhyJoin = brotherWhyJoin;
    }

    public String getBrotherPic() {
        return brotherPic;
    }

    public void setBrotherPic(String brotherPic) {
        this.brotherPic = brotherPic;
    }

    public String getBrotherMajor() {
        return brotherMajor;
    }

    public void setBrotherMajor(String brotherMajor) {
        this.brotherMajor = brotherMajor;
    }

    public String getBrotherCrossSemester() {
        return brotherCrossSemester;
    }

    public void setBrotherCrossSemester(String brotherCrossSemester) {
        this.brotherCrossSemester = brotherCrossSemester;
    }

    public String getBrotherFunFact() {
        return brotherFunFact;
    }

    public void setBrotherFunFact(String brotherFunFact) {
        this.brotherFunFact = brotherFunFact;
    }
}
