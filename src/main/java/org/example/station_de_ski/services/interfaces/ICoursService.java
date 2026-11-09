package org.example.station_de_ski.services.interfaces;
import org.example.station_de_ski.entites.Cours;

import java.util.List;

public interface ICoursService {
    Cours addCours(Cours cours);
    Cours updateCours(Cours cours);
    void deleteCours(long id);
    Cours retriveCours(long id);
    List<Cours> retriveAllCourses();
}
