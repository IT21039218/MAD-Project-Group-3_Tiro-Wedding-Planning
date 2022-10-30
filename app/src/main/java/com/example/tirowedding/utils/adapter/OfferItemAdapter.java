package com.example.tirowedding.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tirowedding.R;
import com.example.tirowedding.utils.model.OfferItem;

import java.util.List;

public class OfferItemAdapter extends RecyclerView.Adapter<OfferItemAdapter.OfferItemViewHolder> {

    private List<OfferItem> offerItemList;
    private OfferClickedListeners offerClickedListeners;
    public OfferItemAdapter(OfferClickedListeners offerClickedListeners){
        this.offerClickedListeners = offerClickedListeners;
    }
    public void setOfferItemList(List<OfferItem> offerItemList){
        this.offerItemList = offerItemList;
    }
    @NonNull
    @Override
    public OfferItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_offer,parent, false);
        return new OfferItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferItemViewHolder holder, int position) {
       OfferItem offerItem = offerItemList.get(position);
        holder.offerNameTv.setText(offerItem.getOfferName());
        holder.offerPriceTv.setText(String.valueOf(offerItem.getOfferPrice()));
        holder.offerImageView.setImageResource(offerItem.getOfferImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offerClickedListeners.onCardClicked(offerItem);
            }
        });

        holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offerClickedListeners.onAddToCartBtnClicked(offerItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(offerItemList == null){
            return 0;
        }
        else{
            return offerItemList.size();
        }
    }

    public class OfferItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView offerImageView , addToCartBtn;
        private TextView offerNameTv,  offerPriceTv;
        private CardView cardView;
        public OfferItemViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.eachShoeCardView);
            addToCartBtn = itemView.findViewById(R.id.eachOfferAddToCartBtn);
            offerNameTv = itemView.findViewById(R.id.eachOfferName);
            offerImageView = itemView.findViewById(R.id.eachOfferIv);
            offerPriceTv = itemView.findViewById(R.id.eachOfferPriceTv);
        }
    }

    public interface OfferClickedListeners{
        void onCardClicked(OfferItem offer);
        void onAddToCartBtnClicked(OfferItem offerItem);
    }
}




