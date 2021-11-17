package com.starryinc.Bookazon.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/searchBooks")
public class BookSearchController {
    private final BookService bookService;

    @Autowired
    public BookSearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/byName/{bookName}")
    public List<Book> searchBooksByName(@PathVariable String bookName) {
        return bookService.getBooksByName(bookName);
    }

    @GetMapping("/byAuthor/{authorId}")
    public List<Book> searchBooksByAuthorId(@PathVariable Long authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }
}
