package ru.netology.shop;

public class RepositoriProduct {
    Product[] products = new Product[0];

    public void save(Product productN) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = productN;
        products = tmp;
    }

    public Product[] getProductAll() {
        return products;
    }

   public void delete(int idN) {

        if (findById (idN) == null) {
            throw new NotFoundException ("Удалеямый вами ID: " + idN + "  отсутствует в товарах");
             };

        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int j = 0;
        for (Product product : products) {
            if (product.getId() != idN) {
                tmp[j] = product;
                j++;
            }
        }
        products = tmp;
    }
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
