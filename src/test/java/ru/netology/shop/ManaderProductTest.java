package ru.netology.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManaderProductTest {

    Book book1 = new Book(111, "Onegin", 50, "Puchkin");
    Smartphone smartphone1 = new Smartphone(211, "DXD", 250, "China");
    Book book2 = new Book(113, "Anech", 550, "Remark");



    @Test
    public void DeleteTest() {
        RepositoriProduct product = new RepositoriProduct();
        ManaderProduct manader = new ManaderProduct(product);
        manader.add(book1);
        manader.add(smartphone1);
        manader.add(book2);

        manader.del(113);

        Product[] actual = product.getProductAll();
        Product[] expected = {book1, smartphone1};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void DeleteTestNo() {
        RepositoriProduct product = new RepositoriProduct();
        ManaderProduct manader = new ManaderProduct(product);
        manader.add(book1);
        manader.add(smartphone1);
        manader.add(book2);

        assertThrows (NotFoundException.class, () -> {
            manader.del(100);
        });
    }

    @Test
    public void AddTest() {
        RepositoriProduct product = new RepositoriProduct();
        ManaderProduct manader = new ManaderProduct(product);
        manader.add(book1);
        manader.add(smartphone1);
        manader.add(book2);

        Product[] actual = product.getProductAll();
        Product[] expected = {book1, smartphone1, book2};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void SearchByTestNo() {
        RepositoriProduct product = new RepositoriProduct();
        ManaderProduct manader = new ManaderProduct(product);
        manader.add(book1);
        manader.add(smartphone1);
        manader.add(book2);

        Product[] actual = manader.searchBy("ta");
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void SearchByTest() {
        RepositoriProduct product = new RepositoriProduct();
        ManaderProduct manader = new ManaderProduct(product);
        manader.add(book1);
        manader.add(smartphone1);
        manader.add(book2);

        Product[] actual = manader.searchBy("ne");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void SearchByTest1() {
        RepositoriProduct product = new RepositoriProduct();
        ManaderProduct manader = new ManaderProduct(product);
        manader.add(book1);
        manader.add(smartphone1);
        manader.add(book2);

        Product[] actual = manader.searchBy("X");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(actual, expected);

    }
}
