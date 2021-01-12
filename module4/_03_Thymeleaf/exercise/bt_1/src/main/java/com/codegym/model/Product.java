package com.codegym.model;

import java.util.Objects;

public class Product {
    private int idProduct;
    private String nameProduct;
    private Double priceProduct;
    private String imgProduct;
    private int quantity;

    public Product(int idProduct, String nameProduct, Double priceProduct, String imgProduct, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.imgProduct = imgProduct;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Product)){
            return false;
        }

        Product otherProduct = (Product) obj;
        if(otherProduct.getIdProduct() == this.idProduct){
            return true;
        }
        return false;
    }
}
