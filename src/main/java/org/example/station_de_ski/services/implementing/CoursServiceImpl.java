package org.example.station_de_ski.services.implementing;
import org.example.station_de_ski.entites.Cours;
import org.example.station_de_ski.services.interfaces.ICoursService;
import org.springframework.stereotype.Service;
import org.example.station_de_ski.repositories.CoursRepository;

import java.util.List;
@Service
public class CoursServiceImpl implements ICoursService {
    private CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public void deleteCours(long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public Cours retriveCours(long id) {
        return coursRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Cours> retriveAllCourses() {
        return coursRepository.findAll();
    }
}
