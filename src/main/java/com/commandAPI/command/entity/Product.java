package com.commandAPI.command.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int serves;

    public Product(String name, String category, double price, String description, int serves) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.serves = serves;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getServes() {
        return serves;
    }

    public void setServes(int serves) {
        this.serves = serves;
    }

    @Override
    public String toString() {
        return "Product " + name;
    }
}
