package ru.netology.shop;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(111, "Onegin", 50, "Puchkin");
        Smartphone smartphone1 = new Smartphone(211, "DXD", 250, "China");
        Book book2 = new Book(113, "Anech", 550, "Remark");

        RepositoriProduct product = new RepositoriProduct();
        ManaderProduct manader = new ManaderProduct(product);

        manader.add(book1);
        manader.add(smartphone1);
        manader.add(book2);

        Product[] result = manader.searchBy("ne");

    }

}
