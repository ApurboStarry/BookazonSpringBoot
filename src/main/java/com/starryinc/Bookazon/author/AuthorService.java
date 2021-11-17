package com.starryinc.Bookazon.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> findAuthorByName(String name) {
        return authorRepository.findAuthorByName(name);
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }
}
