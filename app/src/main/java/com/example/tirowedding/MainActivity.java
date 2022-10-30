package com.example.tirowedding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tirowedding.R;
import com.example.tirowedding.utils.adapter.OfferItemAdapter;
import com.example.tirowedding.utils.model.OfferCart;
import com.example.tirowedding.utils.model.OfferItem;
import com.example.tirowedding.viewmodel.CartViewModel;
import com.example.tirowedding.views.CartActivity;
import com.example.tirowedding.views.DetailedActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OfferItemAdapter.OfferClickedListeners {

    private RecyclerView recyclerView;
    private List<OfferItem> offerItemList;
    private OfferItemAdapter adapter;
    private CartViewModel viewModel;
    private List<OfferCart> offerCartList;
    private CoordinatorLayout coordinatorLayout;
    private ImageView cartImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        setUpList();

        viewModel.getAllCartItems().observe(this, new Observer<List<OfferCart>>() {
            @Override
            public void onChanged(List<OfferCart> offerCarts) {
                offerCartList.addAll(offerCarts);
            }
        });

        adapter.setOfferItemList(offerItemList);
        recyclerView.setAdapter(adapter);

        cartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    private void setUpList() {
        offerItemList.add(new OfferItem("New Year Seasonal", R.drawable.new1, 10));
        offerItemList.add(new OfferItem("Military Offer", R.drawable.new2, 20));
        offerItemList.add(new OfferItem("Christmas Offer", R.drawable.new3, 180.00));
    }

    private void initializeVariables() {

        cartImageView = findViewById(R.id.cartIv);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        offerItemList = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        offerCartList = new ArrayList<>();
        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new OfferItemAdapter(this);

    }

    @Override
    public void onCardClicked(OfferItem offer) {

        Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
        intent.putExtra("offerItem", offer);
        startActivity(intent);

    }

    @Override
    public void onAddToCartBtnClicked(OfferItem offerItem) {
        OfferCart offerCart = new OfferCart();
        offerCart.setOfferName(offerItem.getOfferName());
        offerCart.setOfferPrice(offerItem.getOfferPrice());
        offerCart.setOfferImage(offerItem.getOfferImage());

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

        makeSnackBar("Successfully Added Offer To Cart");

    }
    private void makeSnackBar(String msg){
        Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_SHORT)
                .setAction("Go to Cart", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, CartActivity.class));

                    }
                }).show();
    }
}


