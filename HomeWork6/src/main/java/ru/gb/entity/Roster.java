package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "ROSTER")
@NamedQueries({
        @NamedQuery(name = "Roster.findById",
                query = "SELECT r FROM Roster r WHERE r.id = :id")
})
public class Roster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STATUS")
    private String status = "not empty";

    @ManyToOne()
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "roster_product",
            joinColumns = @JoinColumn(name = "roster_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public boolean addProduct(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }
        return products.add(product);
    }

    public BigDecimal sum(Set<Product> products) {
        BigDecimal sum = new BigDecimal(0);
        for (Product product : products) {
            sum = sum.add((product.getCost()));
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "id_roster=" + id +
                ", products=" + products +
                ", total_cost=" + sum(products) +
                "}\n";
    }
}
