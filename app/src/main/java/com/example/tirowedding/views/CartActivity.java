package com.example.tirowedding.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tirowedding.R;
import com.example.tirowedding.utils.adapter.CartAdapter;
import com.example.tirowedding.utils.model.OfferCart;
import com.example.tirowedding.viewmodel.CartViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.List;

public class CartActivity extends AppCompatActivity implements CartAdapter.CartClickedListeners {

    private RecyclerView recyclerView;
    private CartViewModel cartViewModel;
    private TextView totalCartPriceTV, textView;
    private AppCompatButton checkoutBtn;
    private CardView cardView;
    private CartAdapter cartAdapter;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initializeVariables();

        cartViewModel.getAllCartItems().observe(this, new Observer<List<OfferCart>>() {
            @Override
            public void onChanged(List<OfferCart> offerCarts) {
                double price = 0;
                cartAdapter.setOfferCartList(offerCarts);

                for(int i=0; i<offerCarts.size();i++){
                    price =  price + offerCarts.get(i).getTotalItemPrice();
                }

                totalCartPriceTV.setText(String.valueOf(price));
            }
        });

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartViewModel.deleteAllCartItems();
                textView.setVisibility(View.INVISIBLE);
                checkoutBtn.setVisibility(View.INVISIBLE);
                totalCartPriceTV.setVisibility(View.INVISIBLE);
                button.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.VISIBLE);


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,PaymentActivity.class);
                startActivity(intent);

            }
        });



    }


    private void initializeVariables(){

        cartAdapter = new CartAdapter(this);

        textView = findViewById(R.id.textView2);
        cardView = findViewById(R.id.cartActivityCardView);
        button= findViewById(R.id.button);
        totalCartPriceTV = findViewById(R.id.cartActivityTotalPriceTv);
        checkoutBtn = findViewById(R.id.cartActivityCheckoutBtn);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

    }

    @Override
    public void onDeleteClicked(OfferCart offerCart) {
        cartViewModel.deleteCartItems(offerCart);

    }


}