package com.example.cshop.Objects;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.Map;

public class User {
    private String userPassword,userLastName,userNumber,userFirstName;

    private ArrayList<Product> pastPurchases;

    public static final String NamePref = "Name of User",passwordPref ="PassWord of User";
    
    private boolean isVerified;

    public User(String userFirstName,String userLastName,String userPassword, String userNumber) {
        this.userPassword = userPassword;
        this.userNumber = userNumber;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

}
