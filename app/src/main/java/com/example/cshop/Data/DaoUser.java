package com.example.cshop.Data;


import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cshop.Objects.User;

import com.example.cshop.Utilits.TestDao;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;
import java.util.Map;

public class DaoUser {
    private FirebaseDatabase database;
    private DatabaseReference myRef ;
    private Context context;
    public DaoUser(Context context) {
            this.context = context;
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference(User.class.getSimpleName());
    }
    public void add(User x){
       myRef.child(x.getUserNumber()).setValue(x).addOnSuccessListener(new OnSuccessListener<Void>() {
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

    /*public Task<Void> get(String key){
        return myRef.push().get(key);
    }*/
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
    public Query getUser(String key)
    {
        if(key == null )
            return myRef.orderByKey().limitToFirst(4);
        return myRef.orderByKey().startAfter(key).limitToFirst(4);
    }
}
