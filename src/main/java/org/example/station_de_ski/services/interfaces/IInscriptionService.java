package org.example.station_de_ski.services.interfaces;
import org.example.station_de_ski.entites.Inscription;

import java.util.List;

public interface IInscriptionService {
    Inscription addInscription(Inscription inscription);
    Inscription updateInscription(Inscription inscription);
    void deleteInscription(long id);
    Inscription getInscription(long id);
    List<Inscription> getAllInscriptions();


    Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur);
    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse)        ;
}
