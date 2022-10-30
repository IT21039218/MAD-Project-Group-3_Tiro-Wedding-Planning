package com.example.tirowedding.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tirowedding.R;
import com.example.tirowedding.utils.model.OfferCart;
import com.example.tirowedding.utils.model.OfferItem;
import com.example.tirowedding.viewmodel.CartViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.ArrayList;

public class DetailedActivity extends AppCompatActivity {

    private ImageView offerImageView;
    private TextView offerNameTV, offerPriceTV;
    private AppCompatButton addToCartBtn;
    private OfferItem offer;
    private CartViewModel viewModel;
    private List<OfferCart> offerCartList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        offer = getIntent().getParcelableExtra("offerItem");
        initializeVariables();

        viewModel.getAllCartItems().observe(this, new Observer<List<OfferCart>>() {
            @Override
            public void onChanged(List<OfferCart> offerCarts) {


            }
        });

        if(offer !=null){
            setDataToWidgets();
        }

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertToRoom();
            }
        });

    }

    private void insertToRoom(){

        OfferCart offerCart = new OfferCart();
        offerCart.setOfferName(offer.getOfferName());
        offerCart.setOfferPrice(offer.getOfferPrice());
        offerCart.setOfferImage(offer.getOfferImage());

        final int[] discount = {1};
        final int[] id = new int[1];

        if (!offerCartList.isEmpty()) {
            for (int i=0; i<offerCartList.size(); i++) {
                if (offerCart.getOfferName().equals(offerCartList.get(i).getOfferName())) {
                    discount[0] = offerCartList.get(i).getDiscount();
                    discount[0]++;
                    id[0] = offerCartList.get(i).getId();
                }
            }

        }

        if (discount[0] == 1) {
            offerCart.setDiscount(discount[0]);
            offerCart.setTotalItemPrice(discount[0] * offerCart.getOfferPrice());
            viewModel.insertCartItem(offerCart);
        } else {

            viewModel.updateDiscount(id[0], discount[0]);
            viewModel.updatePrice(id[0], discount[0]*offerCart.getOfferPrice());

        }

        startActivity(new Intent(DetailedActivity.this, CartActivity.class));
    }

    private void setDataToWidgets(){
        offerNameTV.setText(offer.getOfferName());
        offerPriceTV.setText(String.valueOf(offer.getOfferPrice()));
        offerImageView.setImageResource(offer.getOfferImage());
    }

    private void initializeVariables(){
        offerImageView = findViewById(R.id.detailActivityOfferIV);
        offerNameTV = findViewById(R.id.detailActivityOfferNameTV);
        offerPriceTV = findViewById(R.id.detailActivityOfferPriceTV);
        addToCartBtn = findViewById(R.id.detailActivityAddToCartBtn);

        viewModel = new ViewModelProvider(this).get(CartViewModel.class);


    }
}