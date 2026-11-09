package org.example.station_de_ski.services.implementing;
import jakarta.persistence.EntityNotFoundException;
import org.example.station_de_ski.entites.Cours;
import org.example.station_de_ski.entites.Inscription;
import org.example.station_de_ski.entites.Skieur;
import org.example.station_de_ski.repositories.CoursRepository;
import org.example.station_de_ski.repositories.SkieurRepository;
import org.example.station_de_ski.services.interfaces.IInscriptionService;
import org.springframework.stereotype.Service;
import org.example.station_de_ski.repositories.InscriptionRepository;

import java.util.List;
@Service
public class InscriptionServiceImpl implements IInscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private CoursRepository coursRepository;



    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository, SkieurRepository skieurRepository , CoursRepository coursRepository) {
        this.inscriptionRepository = inscriptionRepository;

        this.skieurRepository = skieurRepository;
        this.coursRepository = coursRepository;
    }
    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }
    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }
    @Override
    public void deleteInscription(long id) {
        inscriptionRepository.deleteById(id);
    }
    @Override
    public Inscription getInscription(long id) {
        return inscriptionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {

        // 1. Vérifier que le skieur existe
        Skieur skieur = skieurRepository.findById(numSkieur)
                .orElseThrow(() -> new EntityNotFoundException("Skieur " + numSkieur + " not found"));


        if (inscription.getNumSemaine() < 1 || inscription.getNumSemaine() > 52) {
            throw new IllegalArgumentException("numSemaine must be between 1 and 52");
        }


        inscription.setSkieur(skieur);

        Inscription saved = inscriptionRepository.save(inscription);

        skieur.getInscriptions().add(saved);

        return saved;
    }

    @Override

    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        // 1️⃣ Récupérer l'inscription
        Inscription inscription = inscriptionRepository.findById(numRegistration)
                .orElseThrow(() -> new RuntimeException("Inscription non trouvée"));

        // 2️⃣ Récupérer le cours
        Cours cours = coursRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        // 3️⃣ Assigner le cours à l'inscription
        inscription.setCours(cours);

        // 4️⃣ Ajouter l'inscription au set du cours (si tu veux garder la cohérence bidirectionnelle)
        cours.getInscriptions().add(inscription);

        // 5️⃣ Sauvegarder les deux (JPA cascade peut gérer ça, mais c’est plus sûr)
        inscriptionRepository.save(inscription);
        coursRepository.save(cours);

        return inscription;
    }


}
