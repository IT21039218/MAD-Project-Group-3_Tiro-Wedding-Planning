package com.example.tirowedding.views;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tirowedding.R;
import com.example.tirowedding.utils.adapter.CartAdapter;
import com.example.tirowedding.utils.model.OfferCart;
import com.example.tirowedding.viewmodel.CartViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class PaymentActivity extends AppCompatActivity  {

    FloatingActionButton PayBtn;

    EditText card_number, name, expire, cvv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        boolean isAllFieldsChecked = false;


        PayBtn = findViewById(R.id.PayBtn);

        card_number = findViewById(R.id.card_number);
        name = findViewById(R.id.name);
        expire = findViewById(R.id.expire);
        cvv = findViewById(R.id.cvv);

        // handle the PROCEED button



        PayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentActivity.this.finish();
                System.exit(0);
            }
        });
    }

    private boolean CheckAllFields() {
        if (card_number.length() == 0) {
            card_number.setError("This field is required");
            return false;
        }

        if (name.length() == 0) {
            name.setError("This field is required");
            return false;
        }

        if (expire.length() == 0) {
            expire.setError("Date is required");
            return false;
        }
        if (cvv.length() == 0) {
            cvv.setError("CVV is required");
            return false;
        } else if (cvv.length() > 3) {
            cvv.setError("CVV must be minimum 8 characters");
            return false;
        }

        // after all validation return true.
        return true;


    }

}




