package com.iqoption.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, int price, String name, String manufacturer) {
        super(id, price, name);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(Product product, String request) {
        Smartphone phone = (Smartphone) product;
        if (phone.getManufacturer().equalsIgnoreCase(request)) {
            return true;
        } else {
            return super.matches(product, request);
        }
    }
}


