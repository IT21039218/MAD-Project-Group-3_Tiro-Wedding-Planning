package com.example.tirowedding.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tirowedding.utils.model.OfferCart;

import java.util.List;

@Dao
public interface CartDao {

    @Insert
    void insertCartItem(OfferCart offerCart);

    @Query("SELECT * FROM offer_table")
    LiveData<List<OfferCart>> getAllCartItems();

    @Delete
    void deleteCartItems(OfferCart offerCart);

    @Query("UPDATE offer_table SET discount=:discount WHERE id=:id")
    void updateDiscount(int id, int discount);

    @Query("UPDATE offer_table SET totalItemPrice=:totalItemPrice WHERE id=:id")
    void updatePrice(int id, double totalItemPrice);

    @Query("DELETE FROM offer_table")
    void deleteAllItems();
}
