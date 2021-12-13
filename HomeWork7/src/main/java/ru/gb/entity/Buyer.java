package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "BUYER")
@NamedQueries({
        @NamedQuery(name = "Buyer.findNameById",
                query = "SELECT b.name FROM Buyer b WHERE b.id = :id"),
        @NamedQuery(name = "Buyer.findById",
                query = "SELECT b FROM Buyer b WHERE b.id = :id")
})
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Roster> rosters;

    public boolean addRoster(Roster roster) {
        if (rosters == null) {
            rosters = new HashSet<>();
        }
        return rosters.add(roster);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rosters=" + rosters +
                '}';
    }
}
