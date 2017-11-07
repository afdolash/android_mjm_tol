package com.codesch.afdolash.mjmtol.model;

import java.sql.Time;

/**
 * Created by Afdolash on 11/7/2017.
 */

public class Umkm {
    private int id, idOwner, image;
    private String nameStore, description, category, location;
    private Time open, close;

    public Umkm(int id, int idOwner, int image, String nameStore, String description, String category, String location, Time open, Time close) {
        this.id = id;
        this.idOwner = idOwner;
        this.image = image;
        this.nameStore = nameStore;
        this.description = description;
        this.category = category;
        this.location = location;
        this.open = open;
        this.close = close;
    }

    public int getId() {
        return id;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public String getNameStore() {
        return nameStore;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public Time getOpen() {
        return open;
    }

    public Time getClose() {
        return close;
    }
}
