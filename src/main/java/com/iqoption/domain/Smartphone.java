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
    public boolean matches(String request) {
        if (manufacturer.equalsIgnoreCase(request)) {
            return true;
        } else {
            return super.matches(request);
        }
    }
}


