package com.example.tirowedding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = (EditText) findViewById(R.id.name);
        EditText feedback = (EditText) findViewById(R.id.feedback);
        Button btnsubmit = (Button) findViewById(R.id.btnFeedbacksubmit);
        Button btnsend = (Button) findViewById(R.id.btnFeedbacksend);

        //btnsubmit onclicklistner
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayFeedback();
            }
        });

        //btnsend onclicklistner
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/html");
                intent.putExtra(Intent.EXTRA_EMAIL,new String("xyz@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback From App");
                intent.putExtra(Intent.EXTRA_TEXT,"Name:"+name.getText()+"\n Message:"+feedback.getText());
                try {
                    startActivity(Intent.createChooser(intent,"Please select Email"));

                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(Feedback.this, "There are no Email Clients", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void  DisplayFeedback(){
        Intent intent = new Intent(this, Displayfeedback.class);
        startActivity(intent);
    }
}