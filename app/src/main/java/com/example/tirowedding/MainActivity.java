package com.example.tirowedding;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.tirowedding.DBmain.TABLENAME;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {



    DBmain  dBmain;
    SQLiteDatabase sqLiteDatabase;
    EditText ordername,orderid,orderdetail;
    Button submit,display,edit;
    int id=0;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dBmain= new DBmain(this);
        findid();
        insertData();
        editData();





    }



    private void editData() {
        if (getIntent().getBundleExtra("userdata")!=null){

            Bundle bundle = getIntent().getBundleExtra("userdata");
            id=bundle.getInt("id");
            ordername.setText(bundle.getString("ordername"));
            orderid.setText(bundle.getString("orderid"));
            orderdetail.setText(bundle.getString("orderdetail"));
            edit.setVisibility(View.VISIBLE);
            submit.setVisibility(View.GONE);







        }


    }





    private void insertData() {

        submit.setOnClickListener(view -> {
            ContentValues cv = new ContentValues();
            cv.put("ordername", ordername.getText().toString());
            cv.put("orderid", orderid.getText().toString());
            cv.put("orderdetail", orderdetail.getText().toString());

            sqLiteDatabase = dBmain.getWritableDatabase();
            Long recinsert = sqLiteDatabase.insert(TABLENAME, null, cv);

            Toast.makeText(MainActivity.this, "sucessfully inserted data", Toast.LENGTH_SHORT).show();

            ordername.setText("");
            orderid.setText("");
            orderdetail.setText("");

        });

        //when click on display button open display  data activity
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DisplayData.class);
                startActivity(intent);
            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("ordername", ordername.getText().toString());
                cv.put("orderid", orderid.getText().toString());
                cv.put("orderdetail", orderdetail.getText().toString());

                sqLiteDatabase = dBmain.getReadableDatabase();
                long recedit = sqLiteDatabase.update(TABLENAME, cv, "id=" + id, null);
                if (recedit != -1) {
                    Toast.makeText(MainActivity.this, "Data Updated sucessfuly", Toast.LENGTH_SHORT).show();
                    submit.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.GONE);


                } else {
                    Toast.makeText(MainActivity.this, "somethimg wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    private void findid() {
        ordername= (EditText)findViewById(R.id.edit_ordername);
        orderid= (EditText)findViewById(R.id.edit_orderid);
        orderdetail=(EditText)findViewById(R.id.edit_orderdeatail);
        submit=(Button)findViewById(R.id.submit_btn);
        display=(Button)findViewById(R.id.display_btn);
        edit=(Button)findViewById(R.id.edit_btn);





    }
}

































