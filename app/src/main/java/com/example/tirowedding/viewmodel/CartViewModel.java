package com.example.tirowedding.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tirowedding.repository.CartRepo;
import com.example.tirowedding.utils.model.OfferCart;

import java.util.List;

public class CartViewModel extends AndroidViewModel {

    private CartRepo cartRepo;


    public CartViewModel(@NonNull Application application){
        super(application);
        cartRepo = new CartRepo(application);
    }

    public LiveData<List<OfferCart>> getAllCartItems(){
        return cartRepo.getAllCartItemsLiveData();
    }


    public void insertCartItem(OfferCart offerCart){
        cartRepo.insertCartItem(offerCart);
    }

    public void updateDiscount(int id, int discount){
        cartRepo.updateDiscount(id, discount);
    }

    public void updatePrice(int id, double price){
        cartRepo.updatePrice(id, price);
    }

    public void deleteCartItems(OfferCart offerCart){
        cartRepo.deleteCartItems(offerCart);
    }


    public void deleteAllCartItems() {
        cartRepo.deleteAllCartItems();
    }
}

