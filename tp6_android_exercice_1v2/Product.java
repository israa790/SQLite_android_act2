package com.example.tp6_android_exercice_1v2;


public class Product {

    Integer Id;
    String Name;
    Integer Quantity;
    // -------------Constructor
    public  Product(){ }
    public Product(Integer id, String name, Integer quantity) {
        super();
        this.Id = id;
        this.Name = name;
        this.Quantity = quantity;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}
