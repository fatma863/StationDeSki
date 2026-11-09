package org.example.station_de_ski.services.implementing;
import org.example.station_de_ski.entites.Moniteur;
import org.example.station_de_ski.services.interfaces.IMoniteurService;
import org.springframework.stereotype.Service;
import org.example.station_de_ski.repositories.MoniteurRepository;

import java.util.List;


@Service
public class MoniteurServiceImpl implements IMoniteurService {

    private final MoniteurRepository moniteurRepository;

    public MoniteurServiceImpl(MoniteurRepository moniteurRepository) {
        this.moniteurRepository = moniteurRepository;
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public void deleteMoniteur(long id) {
        moniteurRepository.deleteById(id);
    }

    @Override
    public Moniteur retriveMoniteur(long id) {
        return moniteurRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Moniteur> retriveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

}
