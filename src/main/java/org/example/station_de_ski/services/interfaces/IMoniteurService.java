package org.example.station_de_ski.services.interfaces;
import org.example.station_de_ski.entites.Moniteur;

import java.util.List;

public interface IMoniteurService {
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur(Moniteur moniteur);
    void deleteMoniteur(long id);
    Moniteur retriveMoniteur(long id);
    List<Moniteur> retriveAllMoniteurs();

}
