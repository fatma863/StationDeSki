package org.example.station_de_ski.entites;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
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
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nomAbon;
    private LocalDateTime dateDeb;
    private LocalDateTime dateFin;
    private float prix;
    private TypeAbonnement typeAbon;

}
