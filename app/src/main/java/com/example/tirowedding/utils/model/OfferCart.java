package com.example.tirowedding.utils.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "offer_table")
public class OfferCart {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    private String offerName;
    private int offerImage;
    private double offerPrice;

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public void setOfferImage(int offerImage) {
        this.offerImage = offerImage;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    private int discount;
    private double totalItemPrice;

    public double getTotalItemPrice() {
        return totalItemPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public String getOfferName() {
        return offerName;
    }

    public int getOfferImage() {
        return offerImage;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setTotalItemPrice(double totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }
}
