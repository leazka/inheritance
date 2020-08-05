package com.iqoption.domain;

public class Product {
    private int id;
    private int price;
    private String name;

    public Product() {
    }

    public Product(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean matches(Product product, String request) {
        return product.getName().equalsIgnoreCase(request);
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
