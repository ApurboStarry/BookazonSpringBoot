package com.starryinc.Bookazon.book;

import com.starryinc.Bookazon.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByNameContaining(String bookName);
    List<Book> findBooksByAuthors(Author author);
}
