package com.example.tirowedding;

import android.annotation.SuppressLint;
import android.database.Cursor;

public class Hall {
    public static final String TABLE_NAME = "Hall";
    public static final String NAME = "Name";
    public static String NoOfCounts;
    public static String Budget;
    public static String Venue;
    public String getName;
    String ID;
    String Name;
    String venue;
    Integer noOfCounts;
    Float budget;

    public Hall(){
    }

    public Hall(String name, String venue, Integer noOfCounts, Float budget) {
        Name = name;
        this.venue = venue;
        this.noOfCounts = noOfCounts;
        this.budget = budget;
    }

    @SuppressLint("Range")
    public Hall(Cursor cursor) {
        this.ID = String.valueOf(cursor.getInt(cursor.getColumnIndex(String.valueOf(1))));
        this.Name = cursor.getString(cursor.getColumnIndex(String.valueOf(2)));
        this.venue = cursor.getString(cursor.getColumnIndex(String.valueOf(3)));
        this.noOfCounts = cursor.getInt(cursor.getColumnIndex(String.valueOf(4)));
        this.budget = cursor.getFloat(cursor.getColumnIndex(String.valueOf(5)));
    }



    public String getName() {
        return Name;
    }

    public String getvenue() {
        return venue;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setNoOfCounts(Integer noOfCounts) {
        this.noOfCounts = noOfCounts;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }


    public Integer getnoOfCounts() {
        return noOfCounts;
    }

    public Float getbudget() {
        return budget;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }
}
