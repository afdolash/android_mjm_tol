package com.codesch.afdolash.mjmtol.model;

/**
 * Created by Afdolash on 11/7/2017.
 */

public class Product {
    private int id, idStore, image;
    private String name, unit, description;
    private double price, quantity;

    public Product(int id, int idStore, int image, String name, String unit, String description, double price, double quantity) {
        this.id = id;
        this.idStore = idStore;
        this.image = image;
        this.name = name;
        this.unit = unit;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getIdStore() {
        return idStore;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
