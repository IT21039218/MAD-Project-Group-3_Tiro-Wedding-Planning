package com.example.tirowedding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Activitytwo extends AppCompatActivity {

    TextView count;
     DBHelper dbHelper;
     Context context;
     List<Feedmodel> feedmodels ;
     ListView listView;


























    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitytwo);
                  context=this;

                  dbHelper =new DBHelper(context);


               listView=findViewById(R.id.feedbacklist);


             feedmodels =new ArrayList<>();

             feedmodels=dbHelper.getAllFeemodels();
             Adapter adapter = new Adapter(context,R.layout.single_feedback,feedmodels);
                      listView.setAdapter(adapter);

              listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                           Feedmodel feedmodel = feedmodels.get(position);


                      AlertDialog.Builder builder = new AlertDialog.Builder(context);
                       builder.setTitle(feedmodel.getFeedback());
                       builder.setMessage("enter new");

                       builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                                         dbHelper.deletefeedback(feedmodel.getId());
                                         startActivity(new Intent(context,Activitytwo.class));
                           }
                       });

                       builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               Intent intent = new Intent(context,Activitythree.class);
                               //activity eka start karana gamnama value eka next activity ekata pass karanwa

                               intent.putExtra("id",String.valueOf(feedmodel.getId()));
                               startActivity(intent);



                           }
                       });

                       builder.show();




                  }
              });








    }
}