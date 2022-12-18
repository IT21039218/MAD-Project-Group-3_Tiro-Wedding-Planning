package com.example.tirowedding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activitythree extends AppCompatActivity {

    EditText editfeeback;
    Button edit;
    Context  context;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitythree);


                   context=this;
                   dbHelper = new DBHelper(context);

                   editfeeback=findViewById(R.id.editfeedback);
                   edit=findViewById(R.id.buttonEdit);

                   final  String id= getIntent().getStringExtra("id");

                   Feedmodel feedmodel = dbHelper.getsingleFeedback(Integer.parseInt(id));

                    editfeeback.setText(feedmodel.getFeedback());

                   edit.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           String feedbackedit= editfeeback.getText().toString();

                           Feedmodel feedmodel =new Feedmodel(Integer.parseInt(id),feedbackedit);
                           int state = dbHelper.updatefeedback(feedmodel);
                           System.out.println(state);
                           startActivity(new Intent(context,Activitytwo.class));


                       }
                   });








    }
}