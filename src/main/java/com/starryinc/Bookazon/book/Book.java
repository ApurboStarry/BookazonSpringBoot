package com.starryinc.Bookazon.book;

import com.starryinc.Bookazon.author.Author;
import com.starryinc.Bookazon.category.Category;
import com.starryinc.Bookazon.image.Image;
import com.starryinc.Bookazon.tag.Tag;
import com.starryinc.Bookazon.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String name;
    private Integer quantity;
    private Double unitPrice;
    private String bookCondition;
    private String description;
    private Double latitude;
    private Double longitude;

    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id",
                    referencedColumnName = "id"
            )
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "author_id",
                    referencedColumnName = "id"
            )
    )
    private List<Author> authors;

    @ManyToMany
    @JoinTable(
            name = "book_tags",
            joinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id",
                    referencedColumnName = "id"
            )
    )
    private List<Tag> tags;

    @ManyToMany
    @JoinTable(
            name = "book_images",
            joinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "image_id",
                    referencedColumnName = "id"
            )
    )
    private List<Image> images;
}
