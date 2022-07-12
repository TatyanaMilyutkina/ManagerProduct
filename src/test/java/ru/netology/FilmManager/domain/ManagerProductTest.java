package ru.netology.FilmManager.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerProductTest {
    Book book1 = new Book(1, "NameBook1", 100, "Author1");
    Book book2 = new Book(2, "NameBook2", 200, "Author2");
    Book book3 = new Book(3, "NameBook3", 300, "Author3");
    Smartphone smartphone1 = new Smartphone(4, "NameSma4", 400, "M1");
    Smartphone smartphone2 = new Smartphone(5, "NameSma5", 500, "M2");
    Smartphone smartphone3 = new Smartphone(6, "NameSma6", 600, "M3");
    Smartphone smartphone4 = new Smartphone(7, "NameSma4", 700, "M4");

    @Test
    public void managerSaveAndFindAll() {
        ManagerProduct manager = new ManagerProduct();
        manager.save(book1);
        manager.save(book2);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerRemoveByID() {
        ManagerProduct manager = new ManagerProduct();
        manager.save(book1);
        manager.save(smartphone3);

        Product[] actual = manager.removeByID(1);
        Product[] expected = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerSearchByMore() {
        ManagerProduct manager = new ManagerProduct();
        manager.save(book1);
        manager.save(smartphone3);

        Product[] actual = manager.searchByName("Name6");
        Product[] expected = {smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void managerSearchByOne() {
        ManagerProduct manager = new ManagerProduct();
        manager.save(smartphone3);

        Product[] actual = manager.searchByName("Name6");
        Product[] expected = {smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void managerSearchByNo() {
        ManagerProduct manager = new ManagerProduct();
        manager.save(book1);

        Product[] actual = manager.searchByName("Name6");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void managerSearchByMoreText() {
        ManagerProduct manager = new ManagerProduct();
        manager.save(book1);
        manager.save(smartphone3);
        manager.save(smartphone1);

        Product[] actual = manager.searchByName("Sma");
        Product[] expected = {smartphone3 , smartphone1};
        Assertions.assertArrayEquals(expected, actual);
    }

}
