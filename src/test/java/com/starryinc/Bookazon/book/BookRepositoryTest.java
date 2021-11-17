package com.starryinc.Bookazon.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveBook() {
        Book book = Book.builder()
                .name("DSA")
                .quantity(10)
                .unitPrice(10.99)
                .bookCondition("unused")
                .description("asdf asdf")
                .latitude(20.01)
                .longitude(20.99)
                .build();

        bookRepository.save(book);
    }
}