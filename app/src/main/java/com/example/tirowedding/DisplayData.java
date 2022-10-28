package com.example.tirowedding;



import static com.example.tirowedding.DBmain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;







public class DisplayData extends AppCompatActivity {



    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    MyAdapter myAdapter;















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        dBmain= new DBmain(this);

        findid();
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));






    }



    private void displayData() {

        sqLiteDatabase=dBmain.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select *from "+TABLENAME+"",null);

        ArrayList<Model>modelArrayList=new ArrayList<>();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String  ordername= cursor.getString(1);
            String  orderid = cursor.getString(2);
            String  orderdetail=cursor.getString(3);
            modelArrayList.add(new Model(id,ordername,orderid,orderdetail));

        }
        cursor.close();


        myAdapter= new MyAdapter(this,R.layout.singledata,modelArrayList,sqLiteDatabase);

        recyclerView.setAdapter(myAdapter);


    }

    private void findid() {

        recyclerView=findViewById(R.id.rv);

    }


}