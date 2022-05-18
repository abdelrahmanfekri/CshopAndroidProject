package com.example.cshop.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.cshop.Data.Dao;
import com.example.cshop.Objects.Product;
import com.example.cshop.R;
import com.example.cshop.Utilits.product_adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProductVew extends AppCompatActivity {

    private RecyclerView rv;
    private product_adapter adapter;
    private String lastKey;
    private ProgressBar progressBar;

    class downlaodData extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPostExecute(Void aVoid) {
            progressBar.setVisibility(View.INVISIBLE);
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            loadData();
            return null;
        }
    }

    private boolean loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        progressBar = findViewById(R.id.progressBar);
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager manger = new LinearLayoutManager(this);
        rv.setLayoutManager(manger);
        adapter = new product_adapter(this);
        rv.setAdapter(adapter);

        new downlaodData().execute();

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager manger = (LinearLayoutManager) recyclerView.getLayoutManager();

                int lastPosition = manger.findLastVisibleItemPosition();

                int ItemNumber = manger.getItemCount();

                if(ItemNumber<=lastPosition+1){
                    if(!loading){

                        new downlaodData().execute();

                    }
                }
            }
        });
    }

    private void loadData() {
        Dao product = new Dao<Product>(Product.class.getSimpleName(),this);
        product.getProduct(lastKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Product> tmp = new ArrayList<>();
                for(DataSnapshot x: snapshot.getChildren()) {
                    tmp.add(x.getValue(Product.class));
                    lastKey = x.getKey();
                }
                adapter.addItem(tmp);
                adapter.notifyDataSetChanged();
                loading = false;
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}