package com.example.tirowedding.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tirowedding.R;
import com.example.tirowedding.utils.adapter.CartAdapter;
import com.example.tirowedding.viewmodel.CartViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CardActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partial_main_activity);




    }
}

////public class PaymentActivity extends AppCompatActivity {
//
//
//    private Button button;
//
//    private FloatingActionButton PayBtn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_card);
//
//
//        // handle the PROCEED button
//        PayBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(PaymentActivity.this, CardActivity.class);
//                startActivity(intent);
//            }
//
//        });
//
//    }
//
//
//    }