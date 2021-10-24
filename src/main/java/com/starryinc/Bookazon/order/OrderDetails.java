package com.starryinc.Bookazon.order;

import com.starryinc.Bookazon.book.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetails {
    @Id
    @SequenceGenerator(
            name = "orderDetails_sequence",
            sequenceName = "orderDetails_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderDetails_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "order_summary_id",
            referencedColumnName = "id"
    )
    private OrderSummary orderSummary;

    @ManyToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "id"
    )
    private Book book;

    private Integer quantity;
    private Double unitPrice;
}
