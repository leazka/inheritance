package com.iqoption.repository;

import com.iqoption.domain.Book;
import com.iqoption.domain.Product;
import com.iqoption.domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, 750, "Harry Potter and the Goblet of Fire", "Rowling");
    Book book2 = new Book(3, 240, "Lolita", "Nabokov");
    Smartphone phone1 = new Smartphone(2, 13700, "Pixel", "Google");
    Smartphone phone2 = new Smartphone(4, 25000, "iPhone IV", "Apple");

    @BeforeEach
    void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);
    }

    @Test
    void shouldThrowExceptionIfNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

    @Test
    void shouldRemove(){
        Product[] expected = {book1, book2, phone2};
        repository.removeById(2);
        assertArrayEquals(expected, repository.findAll());
    }

}