package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "PRODUCT")
@NamedQueries({
        @NamedQuery(name = "Product.findTitleById",
                query = "SELECT p.title FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = "Product.findById",
                query = "SELECT p FROM Product p WHERE p.id = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "COST")
    private BigDecimal cost;
    @Column(name = "MANUFACTURE_DATE")
    private LocalDate manufactureDate;
}
