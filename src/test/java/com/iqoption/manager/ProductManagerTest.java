package com.iqoption.manager;

import com.iqoption.domain.Book;
import com.iqoption.domain.Product;
import com.iqoption.domain.Smartphone;
import com.iqoption.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {

    @Mock
    ProductRepository repository;
    @InjectMocks
    ProductManager manager;
    Book book1 = new Book(1, 750, "Harry Potter and the Goblet of Fire", "Rowling");
    Book book2 = new Book(3, 240, "Lolita", "Nabokov");
    Smartphone phone1 = new Smartphone(2, 13700, "Pixel", "Google");
    Smartphone phone2 = new Smartphone(4, 25000, "iPhone IV", "Apple");

    @BeforeEach
    void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
    }

    @Test
    public void shouldFindById() {
        Book returned = book2;
        doReturn(returned).when(repository).findById(3);

        assertEquals(book2, manager.findById(3));
    }

    @Test
    public void shouldRemoveAll() {
        Product[] emptyArray = new Product[0];
        doReturn(emptyArray).when(repository).findAll();

        manager.removeAll();
        assertArrayEquals(emptyArray, manager.findAll());

    }


    @Test
    public void shouldRemoveById() {
        Product[] expected = {book1, book2, phone2};
        doReturn(expected).when(repository).findAll();

        manager.removeById(2);
        assertArrayEquals(expected, manager.findAll());

    }

    @Test
    public void shouldSearchBy(){
        Product[] products = {book1, book2, phone1, phone2};
        doReturn(products).when(repository).findAll();

        Book expectedBook = book2;
        Product[] returnedProducts = manager.searchBy("Lolita");
        assertEquals(expectedBook, returnedProducts[0]);

        Book expectedBook1 = book1;
        Product[] returnedProducts1 = manager.searchBy("Rowling");
        assertEquals(expectedBook1, returnedProducts1[0]);

        Smartphone expectedPhone = phone1;
        Product[] returnedProducts2 = manager.searchBy("pixel");
        assertEquals(expectedPhone, returnedProducts2[0]);

        Smartphone expectedPhone1 = phone2;
        Product[] returnedProducts3 = manager.searchBy("apple");
        assertEquals(expectedPhone1, returnedProducts3[0]);

        Product[] emptyArray = new Product[0];
        Product[] returnedProducts4 = manager.searchBy("crap");
        assertArrayEquals(emptyArray, returnedProducts4);

    }




}