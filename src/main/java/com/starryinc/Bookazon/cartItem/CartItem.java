package com.starryinc.Bookazon.cartItem;

import com.starryinc.Bookazon.book.Book;
import com.starryinc.Bookazon.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItem {
    @Id
    @SequenceGenerator(
            name = "cartItem_sequence",
            sequenceName = "cartItem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cartItem_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "id"
    )
    private Book book;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "userId"
    )
    private User user;

    private int quantity;
}
