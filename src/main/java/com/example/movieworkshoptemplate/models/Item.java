package com.example.movieworkshoptemplate.models;

public class Item {
    int id;
    String name;
    double price;
    String link;

    public Item(int id, String name, double price, String link) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
