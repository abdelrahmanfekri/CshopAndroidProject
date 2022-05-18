package com.example.cshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cshop.Objects.User;

public class login extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private Button signIn;
    private Button signUp;
    private CheckBox remmebreMe;
    private TextView forgetPassword;
    private User user;
    public static final String sharPref = "LoginData";
    public static final String checkBox = "RememberTheUser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        userName = findViewById(R.id.userPhone);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.signin);
        signUp = findViewById(R.id.signup);
        remmebreMe = findViewById(R.id.remmeberMe);
        forgetPassword = findViewById(R.id.forgetpassword);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,signup.class);
                startActivity(intent);
            }
        });

    }
    private void checkData(){

    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(sharPref,MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putBoolean(checkBox,remmebreMe.isActivated());
        if(remmebreMe.isActivated()) {
            editor.putString(User.NamePref, userName.getText().toString());
            editor.putString(User.passwordPref, password.getText().toString());
        }
        editor.apply();
    }
}