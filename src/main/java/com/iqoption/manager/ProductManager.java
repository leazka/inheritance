package com.iqoption.manager;

import com.iqoption.domain.Book;
import com.iqoption.domain.Product;
import com.iqoption.domain.Smartphone;
import com.iqoption.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//@NoArgsConstructor
public class ProductManager {
    private ProductRepository repository;

    public void add(Product item) {
        repository.save(item);
    }


    public Product[] findAll() {
        Product[] products = repository.findAll();
        return products;

    }

    public Product findById(int id) {
        Product product = repository.findbyId(id);
        return product;
    }

    public void removeAll() {
        repository.removeAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String request) {
        Product[] products = repository.findAll();
        Product[] result = new Product[0];
        for (Product product : products) {
            if (matches(product, request)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    private boolean matches(Product product, String request) {
        boolean result = false;
        if (product.getName().equalsIgnoreCase(request)) {
            return true;
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            result = book.getAuthor().equalsIgnoreCase(request);
        }
        if (product instanceof Smartphone) {
            Smartphone phone = (Smartphone) product;
            result = phone.getManufacturer().equalsIgnoreCase(request);
        }
        return result;
    }
}
