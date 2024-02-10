package com.example.eshopsample.model;

public class Product {
    private String id;
    private String name;
    private String cFaname;
    private String cEnname;
    private String description;
    private String price;
    private String photo;

    public Product(String id, String name, String cFaname, String cEnname, String description, String price, String photo) {
        this.id = id;
        this.name = name;
        this.cFaname = cFaname;
        this.cEnname = cEnname;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcFaname() {
        return cFaname;
    }

    public void setcFaname(String cFaname) {
        this.cFaname = cFaname;
    }

    public String getcEnname() {
        return cEnname;
    }

    public void setcEnname(String cEnname) {
        this.cEnname = cEnname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
