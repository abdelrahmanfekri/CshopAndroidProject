package com.example.cshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
public class confirm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Button button = findViewById(R.id.submit_code);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().hasExtra("Code")==false) return;
                String Code = getIntent().getStringExtra("Code");
                TextView textView = findViewById(R.id.editTextNumber);
                if(textView.getText()==null||textView.getText().toString().equals("")||textView.getText().toString().equals(Code)==false){
                    Toast.makeText(confirm.this,"Please Fill All The Required",Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    Toast.makeText(confirm.this,"Code Is Correct",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}