package com.example.tirowedding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Feedmodel> {
       Context context;
       int resource;
       List<Feedmodel> feedmodels;




    Adapter(Context context, int resource, List<Feedmodel> feedmodels){

        super(context,resource,feedmodels );
        this.context= context;
        this.resource=resource;
         this.feedmodels=feedmodels;



    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView userfeedback= row.findViewById(R.id.userfeedback);
        ImageView imageView = row.findViewById(R.id.onGoing);

        Feedmodel feedmodel= feedmodels.get(position);
        userfeedback.setText(feedmodel.getFeedback());
        imageView.setVisibility(View.VISIBLE);






        return row;

    }
}
