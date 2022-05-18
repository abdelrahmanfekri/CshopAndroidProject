package com.example.cshop.Objects;

import android.widget.ImageView;

public class Product {
    private String name,price,descritption,address;
    private int minimumPay,intLimit;
    private boolean isAvailable;
    private ImageView productImage;
    public Product() {
         // empty cons
    }
    public Product(String name, String descritption, String price) {
        this.name = name;
        this.price = price;
        this.descritption = descritption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public int getMinimumPay() {
        return minimumPay;
    }

    public void setMinimumPay(int minimumPay) {
        this.minimumPay = minimumPay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public String getAddress(){return address;}

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescritption() {
        return descritption;
    }
    public int getIntLimit() {
        return intLimit;
    }

    public void setIntLimit(int intLimit) {
        this.intLimit = intLimit;
    }

    public ImageView getProductImage() {
        return productImage;
    }

    public void setProductImage(ImageView productImage) {
        this.productImage = productImage;
    }

}
