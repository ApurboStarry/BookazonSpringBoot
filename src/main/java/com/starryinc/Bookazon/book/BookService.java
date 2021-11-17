package com.starryinc.Bookazon.book;

import com.starryinc.Bookazon.author.Author;
import com.starryinc.Bookazon.author.AuthorService;
import com.starryinc.Bookazon.category.Category;
import com.starryinc.Bookazon.category.CategoryService;
import com.starryinc.Bookazon.tag.Tag;
import com.starryinc.Bookazon.tag.TagService;
import com.starryinc.Bookazon.user.User;
import com.starryinc.Bookazon.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final TagService tagService;
    private final AuthorService authorService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public BookService(BookRepository bookRepository,
                       TagService tagService,
                       AuthorService authorService,
                       CategoryService categoryService,
                       UserService userService) {
        this.bookRepository = bookRepository;
        this.tagService = tagService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    private ArrayList<Tag> extractTags(ArrayList<String> tagsRequest) {
        ArrayList<Tag> tagsToBeSaved = new ArrayList<>();
        for(String tag : tagsRequest) {
            Tag t = tagService.addTag(tag);
            tagsToBeSaved.add(t);
        }

        return tagsToBeSaved;
    }

    private ArrayList<Author> extractAuthors(ArrayList<String> authorsRequest) {
        ArrayList<Author> authorsToBeSaved = new ArrayList<>();
        for(String author : authorsRequest) {
            Optional<Author> authorOptional = authorService.findAuthorByName(author);
            if(!authorOptional.isPresent()) {
                Author newAuthor = authorService.addAuthor(new Author(author));
                authorsToBeSaved.add(newAuthor);
            } else {
                authorsToBeSaved.add(authorOptional.get());
            }
        }

        return authorsToBeSaved;
    }

    private ArrayList<Category> extractCategories(ArrayList<Long> categories) {
        System.out.println(categories);

        ArrayList<Category> categoriesToBeSaved = new ArrayList<>();
        for(Long categoryId : categories) {
            Optional<Category> categoryOptional = categoryService.getCategoryById(categoryId);
            if(categoryOptional.isPresent()) {
                categoriesToBeSaved.add(categoryOptional.get());
            } else {
                // raise an exception
            }
        }

        return categoriesToBeSaved;
    }

    public void sellBook(Map<String, Object> payload) {
        ArrayList<Tag> tags = extractTags((ArrayList<String>) payload.get("tags"));
        ArrayList<Author> authors = extractAuthors((ArrayList<String>) payload.get("authors"));
        ArrayList<Category> categories = extractCategories((ArrayList<Long>) payload.get("categories"));

        Book book = new Book(
                    Long.valueOf(3),
                    (String)payload.get("name"),
                    authors,
                    tags,
                    (Integer) payload.get("quantity"),
                    Double.valueOf(String.valueOf(payload.get("unitPrice"))),
                    (String)payload.get("bookCondition"),
                    (String)payload.get("description"),
                    (Double)payload.get("latitude"),
                    (Double)payload.get("longitude")
                );

        Book savedBook = bookRepository.save(book);
        System.out.println(savedBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String bookName) {
        return bookRepository.findBooksByNameContaining(bookName);
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        Optional<Author> authorOptional = authorService.getAuthorById(authorId);
        if(!authorOptional.isPresent()) {
            return new ArrayList<>();
        }
        return bookRepository.findBooksByAuthors(authorOptional.get());
    }
}
