package org.example.station_de_ski.entites;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long numCours;
private int niveau;
private TypeCours typeCours;
private Support support;
private float prix;
private int creneau;
    public Set<Inscription> getInscriptions() {
        if (inscriptions == null) {
            inscriptions = new HashSet<>();
        }
        return inscriptions;
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cours")
    private Set<Inscription> inscriptions;
}
