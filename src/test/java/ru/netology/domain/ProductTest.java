package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(3, "The Old Man and the Sea", 3000);

    @Test
    void shouldFindByNameIfExist() {
        String nameToFind = "The Old Man and the Sea";
        assertTrue(product.matches(nameToFind));
    }

    @Test
    void shouldNotFindByNameIfNotExist() {
        String nameToFind = "Google";
        assertFalse(product.matches(nameToFind));
    }
}