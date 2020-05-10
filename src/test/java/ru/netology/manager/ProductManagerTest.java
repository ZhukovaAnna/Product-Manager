package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book first = new Book(1, "Charlotte’s Web", 1000, "E.B. White");
    Book second = new Book(2, "Peter Pan", 2000, "J.M. Barrie");
    Book third = new Book(3, "The Old Man and the Sea", 3000, "Ernest Hemmingway");
    Book fourth = new Book(4, "Google", 4000, "Schmidt Rosenberg");
    Smartphone apple = new Smartphone(5, "iPhone 11", 10000, "Apple");
    Smartphone samsung = new Smartphone(6, "Samsung Galaxy", 20000, "Samsung");
    Smartphone google = new Smartphone(7, "Google", 30000, "Google");

    @BeforeEach
    void setup() {
        manager = new ProductManager(repository);
        manager.productAdd(first);
        manager.productAdd(second);
        manager.productAdd(third);
        manager.productAdd(apple);
        manager.productAdd(samsung);
    }

    @Test
    void shouldFindBookByNameExist() {
        String nameToFind = "Peter Pan";
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(nameToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneByNameExist() {
        String nameToFind = "iphone";
        Product[] expected = new Product[]{apple};
        Product[] actual = manager.searchBy(nameToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookByAuthorExist() {
        String authorToFind = "Ernest Hemmingway";
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy(authorToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneByProducerExist() {
        String producerToFind = "Samsung";
        Product[] expected = new Product[]{samsung};
        Product[] actual = manager.searchBy(producerToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBookByNameNotExists() {
        String textToFind = "Mr. Mercedes";
        manager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBookByAuthorNotExist() {
        String authorToFind = "Stephen King";
        manager.searchBy(authorToFind);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(authorToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartphoneByNameNotExist() {
        String nameToFind = "LG V60 ThinQ";
        manager.searchBy(nameToFind);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(nameToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartphoneByProducerNotExist() {
        String producerToFind = "LG";
        manager.searchBy(producerToFind);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(producerToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneAndBookWithIdenticalNames() {
        manager.productAdd(fourth);
        manager.productAdd(google);
        String nameToFind = "Google";
        Product[] expected = new Product[]{fourth,google};
        Product[] actual = manager.searchBy(nameToFind);
        assertArrayEquals(expected, actual);
    }

}