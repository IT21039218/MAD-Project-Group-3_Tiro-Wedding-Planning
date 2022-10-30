package com.example.tirowedding.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tirowedding.dao.CartDao;
import com.example.tirowedding.utils.model.OfferCart;

@Database(entities = {OfferCart.class}, version = 1)
public abstract class CartDatabase extends RoomDatabase {

    public abstract CartDao cartDao();
    private static CartDatabase instance;

    public static synchronized CartDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext()
                            , CartDatabase.class, "OfferDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
