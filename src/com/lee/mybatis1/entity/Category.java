package com.lee.mybatis1.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库表实体类
 */

public class Category  implements Serializable {
    private int id ;
    private String name ;
    //private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'';
    }
}
