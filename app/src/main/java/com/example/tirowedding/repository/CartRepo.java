package com.example.tirowedding.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tirowedding.dao.CartDao;
import com.example.tirowedding.database.CartDatabase;
import com.example.tirowedding.utils.model.OfferCart;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CartRepo {

    private CartDao cartDao;
    private LiveData<List<OfferCart>> allCartItemsLiveData;
    private Executor executor = Executors.newSingleThreadExecutor();

    public LiveData<List<OfferCart>> getAllCartItemsLiveData() {
        return allCartItemsLiveData;
    }

    public CartRepo(Application application){
        cartDao = CartDatabase.getInstance(application).cartDao();
        allCartItemsLiveData = cartDao.getAllCartItems();

    }
    public void insertCartItem(OfferCart offerCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.insertCartItem(offerCart);
            }
        });
    }

    public void deleteCartItems(OfferCart offerCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.deleteCartItems(offerCart);
            }
        });
    }

    public void updateDiscount(int id, int discount){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.updateDiscount(id, discount);
            }
        });
    }
    public void updatePrice(int id,double price){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.updatePrice(id, price);
            }
        });
    }

    public void deleteAllCartItems(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.deleteAllItems();
            }
        });

    }
}

