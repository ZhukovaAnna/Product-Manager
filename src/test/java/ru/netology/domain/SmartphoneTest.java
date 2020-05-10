package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone=new Smartphone(1, "Samsung Galaxy", 20000, "Samsung");

    @Test
    void shouldFindByProducerIfExist(){
        String producerToFind = "Samsung";
        assertTrue(smartphone.matches(producerToFind));
    }

    @Test
    void shouldNotFindByProducerIfNotExist(){
        String producerToFind = "Apple";
        assertFalse(smartphone.matches(producerToFind));
    }

    @Test
    void shouldFindByNameIfExist(){
        String nameToFind = "Samsung Galaxy";
        assertTrue(smartphone.matches(nameToFind));
    }

    @Test
    void shouldNotFindByNameIfNotExist(){
        String nameToFind = "iPhone 11";
        assertFalse(smartphone.matches(nameToFind));
    }


}