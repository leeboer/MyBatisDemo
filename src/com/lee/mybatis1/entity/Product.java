package com.lee.mybatis1.entity;

/**
 * Created by liboar on 2019/5/23.
 */

public class Product {
    private int id ;
    private String name;
    private double price;
    private int groups;
    private Category category;


    public Product(){

    }
    public Product(int id, String name, double price,int groups) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.groups = groups;
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


    public int getGroups() {
        return groups;
    }

    public void setGroups(int groups) {
        this.groups = groups;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", groups=" + groups +
                '}';
    }
}
