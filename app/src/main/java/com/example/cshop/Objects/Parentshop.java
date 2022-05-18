package com.example.cshop.Objects;

import android.widget.ImageView;

import com.example.cshop.Data.Dao;
import com.example.cshop.Utilits.TestDao;
import com.google.firebase.database.Exclude;

import java.util.ArrayList;

public class Parentshop {

    private ImageView mainImage,logoImage;

    private String name,description,discoint,addressContentMap,deliveryTime;

    private Dao daoProduct;
    @Exclude
    private String address;

    private ArrayList<String> Products;
    private float rating;


    private State state;

    public Parentshop() {
        //Empty;
    }

    public Parentshop(String name, String description) {
        Products = new ArrayList<>();
        this.name = name;
        daoProduct = new Dao<Product>(Product.class.getSimpleName(),null);
        this.description = description;
    }


    public void addProduct(String key){
        Products.add(key);
    }


    public ArrayList<String> getProducts() {
        return Products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscoint() {
        return discoint;
    }

    public void setDiscoint(String discoint) {
        this.discoint = discoint;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAddressContentMap() {
        return addressContentMap;
    }

    public void setAddressContentMap(String addressContentMap) {
        this.addressContentMap = addressContentMap;
    }

    @Exclude
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ImageView getMainImage() {
        return mainImage;
    }

    public void setMainImage(ImageView mainImage) {
        this.mainImage = mainImage;
    }

    public ImageView getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(ImageView logoImage) {
        this.logoImage = logoImage;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
