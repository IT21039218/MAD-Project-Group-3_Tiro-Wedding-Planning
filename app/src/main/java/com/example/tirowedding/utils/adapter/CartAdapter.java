package com.example.tirowedding.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;




import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tirowedding.R;
import com.example.tirowedding.utils.model.OfferCart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private CartClickedListeners cartClickedListeners;
    private List<OfferCart> offerCartList;

    public CartAdapter(CartClickedListeners cartClickedListeners) {
        this.cartClickedListeners = cartClickedListeners;
    }

    public void setOfferCartList(List<OfferCart> offerCartList) {
        this.offerCartList = offerCartList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {


        OfferCart offerCart = offerCartList.get(position);
        holder.offerImageView.setImageResource(offerCart.getOfferImage());
        holder.offerNameTv.setText(offerCart.getOfferName());
        holder.offerDiscount.setText(offerCart.getDiscount() + "");
        holder.offerPriceTv.setText(offerCart.getTotalItemPrice() + "");

        holder.deleteOfferBtn.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        cartClickedListeners.onDeleteClicked(offerCart);
    }
    });


}

     @Override
    public int getItemCount() {
        if (offerCartList == null) {
            return 0;
        } else {
           return offerCartList.size();
        }
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{

        public ImageView deleteOfferBtn;
        private TextView offerNameTv, offerPriceTv, offerDiscount;
        private ImageView offerImageView;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            offerNameTv = itemView.findViewById(R.id.eachCartItemName);
            offerPriceTv = itemView.findViewById(R.id.eachCartItemPriceTv);
            deleteOfferBtn = itemView.findViewById(R.id.eachCartItemDeleteBtn);
            offerImageView = itemView.findViewById(R.id.eachCartItemIV);
            offerDiscount = itemView.findViewById(R.id.eachCartItemDiscountTV);

        }

    }

    public interface CartClickedListeners{
        void onDeleteClicked(OfferCart offerCart);
       }

}
