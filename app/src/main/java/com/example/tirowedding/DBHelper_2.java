package com.example.tirowedding;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DBHelper_2 extends SQLiteOpenHelper {
    private  static  final int VERSION=1;
    private  static  final  String  DB_NAME ="newfeed";
    private  static  final  String  TABLE_NAME ="newfeed";


    private  static  final  String ID = "id";
    private  static  final  String FEEDBACK= "feedback";







    //first  me  meka  run wela database  ekek create  wenawa
    public DBHelper_2(@Nullable Context context) {
        super(context, DB_NAME,null,VERSION);
    }
     //second  run this method  eken  table create krala denawa





    @Override
    public void onCreate(SQLiteDatabase db) {




        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +FEEDBACK+" TEXT" +
                ");";





        db.execSQL(TABLE_CREATE_QUERY);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public  void  addfeedback(Feedmodel feedmodel){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();


        ContentValues contentValues = new ContentValues();

           contentValues.put(FEEDBACK,feedmodel.getFeedback());


           sqLiteDatabase.insert(TABLE_NAME,null,contentValues);


          sqLiteDatabase.close();







    }





    public int countToDo(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }



    public List<Feedmodel> getAllFeemodels(){

        List<Feedmodel> feedmodels = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {

                Feedmodel feedmodel = new Feedmodel();
                // mmgby6hh
                feedmodel.setId(cursor.getInt(0));
                feedmodel.setFeedback(cursor.getString(1));


                //toDos [obj,objs,asas,asa]
                feedmodels.add(feedmodel);
            }while (cursor.moveToNext());
        }
        return feedmodels;
    }




    public  void  deletefeedback(int id){

      SQLiteDatabase db =  getWritableDatabase();
       db.delete(TABLE_NAME,ID+" =?",new String[]{String.valueOf(id)});
       db.close();


    }



          public  Feedmodel getsingleFeedback(int id){

               SQLiteDatabase db = getWritableDatabase();


               Cursor  cursor = db.query(TABLE_NAME,new String[]{ID,FEEDBACK},ID + "= ?",new String[]{String.valueOf(id)},null,null,null);


                Feedmodel feedmodel;

                if (cursor!=null){
                       cursor.moveToFirst();


                    feedmodel = new Feedmodel(cursor.getInt(0),cursor.getString(1));

                           return feedmodel;


                }



                       return  null;



          }




          public  int updatefeedback(Feedmodel feedmodel){


                       SQLiteDatabase db= getWritableDatabase();
                          ContentValues  contentValues = new ContentValues();

                          contentValues.put(FEEDBACK,feedmodel.getFeedback());

                            int status= db.update(TABLE_NAME,contentValues,ID+" =?",new String[]{String.valueOf(feedmodel.getId())});

               db.close();



         return  status;

          }
















}
