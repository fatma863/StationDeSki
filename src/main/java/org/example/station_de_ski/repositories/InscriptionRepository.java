package org.example.station_de_ski.repositories;
import org.example.station_de_ski.entites.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
