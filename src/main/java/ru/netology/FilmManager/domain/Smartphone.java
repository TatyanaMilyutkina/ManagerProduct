package ru.netology.FilmManager.domain;

public class Smartphone extends Product {

    public String manufacturer;

    public Smartphone(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.manufacturer = manufacturer;

    }
}
