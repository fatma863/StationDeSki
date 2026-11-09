package org.example.station_de_ski.services.implementing;
import org.example.station_de_ski.entites.Skieur;
import org.example.station_de_ski.services.interfaces.ISkieurService;
import org.springframework.stereotype.Service;
import org.example.station_de_ski.repositories.SkieurRepository;

import java.util.List;
@Service
public class SkieurServiceImpl implements ISkieurService {
    private SkieurRepository skieurRepository;
    public SkieurServiceImpl(SkieurRepository skieurRepository) {
        this.skieurRepository = skieurRepository;
    }
    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }
    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }
    @Override
    public void removeSkieur(long id) {
        skieurRepository.deleteById(id);
    }
    @Override
    public Skieur retriveSkieur(long id) {
        return skieurRepository.findById(id).orElseThrow();
    }
    @Override
    public List<Skieur> retriveAllSkieurs() {
        return skieurRepository.findAll();
    }
}
