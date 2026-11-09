package org.example.station_de_ski.services.implementing;
import lombok.AllArgsConstructor;
import org.example.station_de_ski.entites.Abonnement;
import org.example.station_de_ski.services.interfaces.IAbonnementService;
import org.springframework.stereotype.Service;
import org.example.station_de_ski.repositories.AbonnementRepository;

import java.util.List;
@Service
public class AbonnementServiceImpl implements IAbonnementService {
    private final AbonnementRepository abonnementRepository;

    public AbonnementServiceImpl(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }
    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public void deleteAbonnement(long id) {
abonnementRepository.deleteById(id);
    }

    @Override
    public Abonnement getAbonnement(long id) {
        return abonnementRepository.findById(id).orElseThrow();
    }



    @Override
    public List<Abonnement> getAllAbonnement() {
        return abonnementRepository.findAll();
    }
}
