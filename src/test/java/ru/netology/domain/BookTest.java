package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book = new Book(1, "Charlotte’s Web", 1000, "E.B. White");

    @Test
    void shouldFindByNameIfExist(){
        String nameToFind = "Charlotte’s Web";
        assertTrue(book.matches(nameToFind));
    }

    @Test
    void shouldNotFindByNameIfNotExist(){
        String nameToFind = "Peter Pan";
        assertFalse(book.matches(nameToFind));
    }

    @Test
    void shouldFindByAuthorIfExist(){
        String authorToFind = "E.B. White";
        assertTrue(book.matches(authorToFind));
    }

    @Test
    void shouldNotFindByAuthorIfNotExist(){
        String autorToFind ="J.M. Barrie";
        assertFalse(book.matches(autorToFind));
    }
}