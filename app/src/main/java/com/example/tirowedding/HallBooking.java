package com.example.tirowedding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HallBooking extends AppCompatActivity {
    public Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_booking);

        button1 = (Button) findViewById(R.id.btnh1);
        button2 = (Button) findViewById(R.id.btnh2);

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent1 = new Intent(Hall.this,Offers.class);
                //Intent intent2 = new Intent(Hall.this,Payment.class);
                //startActivity(intent1);
                //startActivity(intent2);
            }
        });*/
    }
}