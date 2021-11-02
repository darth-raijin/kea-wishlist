package com.example.demo.models;

import java.util.ArrayList;

public class WishList {
    String name;
    String description;
    int id;
    ArrayList<Item> itemArrayList;

    public WishList(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
        itemArrayList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "WishList{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", itemArrayList=" + itemArrayList +
                '}';
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }
}
