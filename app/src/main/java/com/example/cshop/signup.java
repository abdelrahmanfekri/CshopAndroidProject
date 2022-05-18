package com.example.cshop;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cshop.Objects.User;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
public class signup extends AppCompatActivity {
    private static final String TAG = "signup";
    private Button signup;
    private EditText firstName;
    private EditText lastName;
    private EditText userPhoneNumber;
    private EditText userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup = findViewById(R.id.sign_up);
        firstName = findViewById(R.id.user_first_name);
        lastName = findViewById(R.id.user_last_name);
        userPhoneNumber = findViewById(R.id.user_phone_number);
        userPassword = findViewById(R.id.user_password);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data[] ={firstName.getText().toString(),
                        lastName.getText().toString(),
                        userPassword.getText().toString(),
                        userPhoneNumber.getText().toString()};
                if(checkEmpty(data)){
                    Log.i("signup","checkEmpty");
                    Toast.makeText(signup.this,"Please Fill All The Required",Toast.LENGTH_LONG).show();
                    return;
                }
                if(isNumber(data[3])==false||data[3].substring(0,2).equals("01")==false){
                    Log.i("signup","isNumber");
                    Toast.makeText(signup.this,"Please Enter Your Number Correctly",Toast.LENGTH_LONG).show();
                    return;
                }
                User user = new User(firstName.getText().toString(),
                        lastName.getText().toString(),
                        userPassword.getText().toString(),userPhoneNumber.getText().toString());
                Map<String,Object> map = new HashMap<>();
                map.put("user",user);
                signup.setEnabled(false);
                FirebaseFirestore dp = FirebaseFirestore.getInstance();

            }
        });
    }
    private boolean isNumber(String s){
        try{
            Double.parseDouble(s);
        }catch (Exception e){
            return false;
        }
        if(s.length()!=11)return false;
        return true;
    }
    private boolean checkEmpty(String[]arr){
        for(String i:arr){
            if(i==null||i.equals("")){
                return true;
            }
        }
        return false;
    }
}