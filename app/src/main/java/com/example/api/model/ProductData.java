package com.example.api.model;

public class ProductData {

    public Product data;
    public Support support;

    public ProductData(Product data, Support support) {
        this.data = data;
        this.support = support;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}

