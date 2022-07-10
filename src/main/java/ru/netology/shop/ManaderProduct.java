package ru.netology.shop;

public class ManaderProduct {
    private RepositoriProduct repository;

    public ManaderProduct(RepositoriProduct repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public void del(int id) { repository.delete(id);}

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.getProductAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }

        }
        // "добавляем в конец" массива result продукт product
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }


}