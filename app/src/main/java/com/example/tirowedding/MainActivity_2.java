package com.example.feedback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvFeedback;
    RatingBar rbStars;
    Button add;
    EditText  feedback;

    Context context;
    DBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFeedback = findViewById(R.id.tvFeedback);
        rbStars = findViewById(R.id.rbStars);
        add= findViewById(R.id.btnSend);
        feedback=findViewById(R.id.editfeedback);
        context=this;
        dbHelper = new DBHelper(context);




        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==0)
                {
                    tvFeedback.setText("Very Dissatisfied");
                }
                else if(rating==1)
                {
                    tvFeedback.setText("Dissatisfied");
                }
                else if(rating==2 || rating==3)
                {
                    tvFeedback.setText("OK");
                }
                else if(rating==4)
                {
                    tvFeedback.setText("Satisfied");
                }
                else if(rating==5)
                {
                    tvFeedback.setText("Very Satisfied");
                }
                else
                {

                }
            }
        });

               //send  button  eka  click  karama second activity  ekata yanawa



                 add.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {

                         String userfeedback= feedback.getText().toString();
                         Feedmodel feedmodel= new Feedmodel(userfeedback);
                           dbHelper.addfeedback(feedmodel);
                            startActivity(new Intent(context,Activitytwo.class));



                     }









                 });









    }
}