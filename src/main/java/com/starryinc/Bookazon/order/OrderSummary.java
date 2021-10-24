package com.starryinc.Bookazon.order;

import com.starryinc.Bookazon.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_summary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSummary {
    @Id
    @SequenceGenerator(
            name = "order_summary_sequence",
            sequenceName = "order_summary_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_summary_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "userId"
    )
    private User user;

    private String paymentMethod;
    private String deliveryType;

}
