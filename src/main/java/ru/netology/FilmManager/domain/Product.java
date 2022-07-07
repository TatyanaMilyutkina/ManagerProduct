package ru.netology.FilmManager.domain;

public class Product {
    protected int id;
    protected String name;
    protected int cost;
    // private Product[] products = new Product[0];


    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
