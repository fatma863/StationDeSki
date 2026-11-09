package org.example.station_de_ski.entites;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
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
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numPiste;
    private String nomPiste;
    private int longeur;
    private int pente;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    @ManyToMany(mappedBy = "pistes", cascade = CascadeType.ALL)
    private Set<Skieur> skieurs;
}
