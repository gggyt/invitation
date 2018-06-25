package com.example.demo.Entity;

/**
 * Created by ggg on 2018/6/15.
 */
public class Category{
   private String ca_name;


    public String getCa_name() {
        return ca_name;
    }

    public void setCa_name(String ca_name) {
        this.ca_name = ca_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                " ca_name='" + ca_name + '\'' +
                '}';
    }
}
