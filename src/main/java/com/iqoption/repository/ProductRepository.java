package com.iqoption.repository;

import com.iqoption.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;

        items = tmp;

    }

    public void removeById(int id) {
        Product[] tmp = new Product[items.length - 1];

        int index = 0;

        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Product findbyId(int id) {
        Product product = null;
        for (Product item : items) {
            if (item.getId() == id) {
                product = item;
            }
        }
        return product;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeAll() {
        items = new Product[0];
    }
}


