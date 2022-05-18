package com.example.cshop.Utilits;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cshop.Objects.Parentshop;

import com.example.cshop.R;

import java.util.ArrayList;


public class shop_adapter extends RecyclerView.Adapter {

    class shop_holder extends RecyclerView.ViewHolder{
        ImageView shopeLogo,mainImage;
        TextView discount,deliverytime,name,description;
        RatingBar Evaluation;

        public shop_holder(@NonNull View itemView) {
            super(itemView);
            shopeLogo = itemView.findViewById(R.id.shop_logo);
            mainImage = itemView.findViewById(R.id.main_image);
            discount = itemView.findViewById(R.id.shop_discount);
            deliverytime = itemView.findViewById(R.id.delivery_time);
            name = itemView.findViewById(R.id.shop_name);
            description = itemView.findViewById(R.id.shop_description);
            Evaluation = itemView.findViewById(R.id.evaluation);
        }
    }

    private ArrayList<Parentshop> list;

    public Context context;
    public shop_adapter(Context context, ClipData.Item type){
        this.context = context;
        list = new ArrayList<>();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_object_item,parent,false);
        return new shop_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         if(holder instanceof shop_holder ){
             shop_holder hold = (shop_holder)holder;
             Parentshop object = list.get(position);
             hold.discount.setText(object.getDiscoint());
             hold.deliverytime.setText(object.getDeliveryTime());
             hold.name.setText(object.getName());
             hold.description.setText(object.getDescription());
             hold.Evaluation.setRating( object.getRating());
         }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
