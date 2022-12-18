package com.example.tirowedding;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
//import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

//import static com.example.tirowedding.DataBaseHelper.Hall.*;

import com.example.tirowedding.Hall;

public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="androidtutorial";
    //public static final int DATABASE_VERSION=1;
    //public static final String TABLE_Hall="hall";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Qry="CREATE TABLE " + Hall.TABLE_NAME
                +" ( ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " Name TEXT,"
                + " venue TEXT,"
                + " noOfCounts INTEGER,"
                + " budget TEXT)";

        db.execSQL(Qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //region Hall CRUD
    public boolean addInfo(String Name, String venue, int noOfCounts, float budget){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Hall.NAME,Name);
        values.put(Hall.Venue,venue);
        values.put(Hall.NoOfCounts,noOfCounts);
        values.put(Hall.Budget,budget);
        long newRowID = db.insert(Hall.TABLE_NAME,null,values);

        if(newRowID >=1)
            return true;
        else
            return false;
    }

    public void InsertHall(Hall hall) {
        SQLiteDatabase db=this.getWritableDatabase();
        String Qry="INSERT INTO "
                + Hall.TABLE_NAME
                +"(Name,vanue,noOfCounts,budget)"
                +"VALUES ('"+hall.getName +"','"+hall.getvenue() +"','"+hall.getnoOfCounts() +"','"+hall.getbudget()+"')";
        db.execSQL(Qry);
    }

    public boolean deleteHall(Integer id) {
        SQLiteDatabase db=this.getWritableDatabase();
        String delQuery="DELETE FROM hall WHERE ID="+id;
        db.execSQL(delQuery);
        return true;
    }

    public void UpdateHall(Hall hall) {
        SQLiteDatabase db=this.getWritableDatabase();
        String Qry="UPDATE hall " +
                "SET Name='"+hall.getName()+"'"+
                ","+ " venue='"+hall.getvenue()+"'"+
                ","+ " noOfCounts='"+hall.getnoOfCounts()+"'"+
                ","+ " budget='"+hall.getbudget()+"'"+
                " WHERE _id=" +hall.getID();
        db.execSQL(Qry);
    }

    public List<Hall> getHall()
    {
        List<Hall> hallList =new ArrayList<>();
        String query="SELECT * FROM "+ Hall.TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do {
                Hall hall=new Hall(cursor);
                hallList.add(hall);
            }while (cursor.moveToNext());
        }
        return hallList;
    }
}
