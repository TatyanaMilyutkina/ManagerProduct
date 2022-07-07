package ru.netology.FilmManager.domain;

public class ManagerProduct {

    private Product[] products = new Product[0];

    public void save(Product product) {

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }


    public Product[] removeByID(int id) {

        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product products : products) {
            if (products.getId() != id) {
                tmp[index] = products;
                index++;
            }
        }
        products = tmp;
        return tmp;
    }

    public Product[] searchByName(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : products) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }


}
