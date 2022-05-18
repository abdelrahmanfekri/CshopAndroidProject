package com.example.cshop.Data;


import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cshop.Objects.Parentshop;
import com.example.cshop.Objects.Product;
import com.example.cshop.Objects.User;

import com.example.cshop.Utilits.TestDao;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;

public class Dao<Item>{
    private FirebaseDatabase database;
    private DatabaseReference myRef ;
    private Context context;
    public Dao(String key, Context context) {
        this.context = context;
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(key);
    }
    public void add(Item x){
        String address = myRef.push().getKey();
        if(x instanceof Parentshop)
        ((Parentshop)x).setAddress(address);
        else if(x instanceof Product)
            ((Product)x).setAddress(address);
        myRef.child(address).setValue(x).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context, "succes add", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context, "fail add", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void update(String Key, Map<String,Object>map){

        myRef.child(Key).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context, "succes update", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context, "fail update", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void remove(String key){
        myRef.child(key).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context, "succes remove", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context, "fail remove", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public Query getProduct(String key)
    {
        if(key == null )
            return myRef.orderByKey().limitToFirst(4);
        return myRef.orderByKey().startAfter(key).limitToFirst(4);
    }
}
