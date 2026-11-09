package org.example.station_de_ski.services.interfaces;
import org.example.station_de_ski.entites.Skieur;

import java.util.List;

public interface ISkieurService {
 Skieur addSkieur(Skieur skieur);
 Skieur updateSkieur(Skieur skieur);
 void removeSkieur(long id);
 Skieur retriveSkieur(long id);
List<Skieur> retriveAllSkieurs();
}
