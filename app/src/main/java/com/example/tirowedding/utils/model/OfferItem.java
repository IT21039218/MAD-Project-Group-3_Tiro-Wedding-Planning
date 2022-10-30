package com.example.tirowedding.utils.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OfferItem implements Parcelable {

    private String offerName;
    private int offerImage;
    private double offerPrice;

    public OfferItem(String offerName, int offerImage, double offerPrice) {
        this.offerName = offerName;
        this.offerImage = offerImage;
        this.offerPrice = offerPrice;
    }

    protected OfferItem(Parcel in) {
        offerName = in.readString();
        offerImage = in.readInt();
        offerPrice = in.readDouble();
    }

    public static final Creator<OfferItem> CREATOR = new Creator<OfferItem>() {
        @Override
        public OfferItem createFromParcel(Parcel in) {
            return new OfferItem(in);
        }

        @Override
        public OfferItem[] newArray(int size) {
            return new OfferItem[size];
        }
    };

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public int getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(int offerImage) {
        this.offerImage = offerImage;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(offerName);
        parcel.writeInt(offerImage);
        parcel.writeDouble(offerPrice);
    }
}
