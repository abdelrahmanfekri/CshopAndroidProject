package com.example.cshop.Utilits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cshop.Objects.Product;
import com.example.cshop.R;

import java.util.ArrayList;

public class product_adapter extends RecyclerView.Adapter {

    class product_holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,description,price;

        public product_holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_of_content);
            description = itemView.findViewById(R.id.description_content);
            price = itemView.findViewById(R.id.price_content);
            imageView = itemView.findViewById(R.id.image_of_content);
        }
    }
    private ArrayList<Product> list;
    private Context context;
    public product_adapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addItem(ArrayList<Product> x){
        if(x==null) Toast.makeText(context, "Null X", Toast.LENGTH_SHORT).show();
        if(list==null)list = x;
        list.addAll(x);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item_view,parent,false);
        return new product_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof product_holder){
            product_holder ph = (product_holder) holder;
            Product product = (Product) list.get(position);
            ph.name.setText(product.getName());
            ph.description.setText(product.getDescritption());
            ph.price.setText(product.getPrice());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
