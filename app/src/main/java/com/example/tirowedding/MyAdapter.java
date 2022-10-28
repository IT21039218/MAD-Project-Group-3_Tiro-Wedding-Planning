package com.example.tirowedding;


import static com.example.tirowedding.DBmain.TABLENAME;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ModelViewHolder> {

    Context  context;
    ArrayList<Model>modelArrayList=new ArrayList<>();

    SQLiteDatabase sqLiteDatabase;

    public MyAdapter(Context context, int singledata, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public MyAdapter.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.singledata,null);

        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ModelViewHolder holder,  int position) {

        final Model model=modelArrayList.get(position);
        holder.txtordername.setText(model.getOrdername());
        holder.txtorderid.setText(model.getOrderid());
        holder.txtorderdetail.setText(model.getOrderdetail());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("id",model.getId());
                bundle.putString("ordername",model.getOrdername());
                bundle.putString("orderid",model.getOrderid());
                bundle.putString("orderdetail",model.getOrderdetail());
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);

            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            DBmain dBmain=new DBmain(context);

            @Override
            public void onClick(View view) {
                sqLiteDatabase= dBmain.getReadableDatabase();
                long delete=sqLiteDatabase.delete(TABLENAME,"id="+model.getId(),null);
                if (delete!=-1){

                    Toast.makeText(context, "delete data sucessfully", Toast.LENGTH_SHORT).show();
                    modelArrayList.remove(position);

                    notifyDataSetChanged();




                }

            }
        });






    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {

        TextView txtordername,txtorderid,txtorderdetail;

        Button edit,delete;







        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);

            txtordername=(TextView)itemView.findViewById(R.id.txtordername);
            txtorderdetail=(TextView) itemView.findViewById(R.id.txtorderdetail);
            txtorderid=(TextView)itemView.findViewById(R.id.txtorderid);
            edit=(Button)itemView.findViewById(R.id.txt_btn_edit);
            delete=(Button)itemView.findViewById(R.id.txt_btn_delete);






        }
    }
}




