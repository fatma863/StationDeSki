package org.example.station_de_ski.services.implementing;
import org.example.station_de_ski.entites.Piste;
import org.example.station_de_ski.services.interfaces.IPisteService;
import org.springframework.stereotype.Service;
import org.example.station_de_ski.repositories.PisteRepository;

import java.util.List;
@Service
public class PisteServiceImpl implements IPisteService {
    private PisteRepository pisteRepository;
    public PisteServiceImpl(PisteRepository pisteRepository) {
        this.pisteRepository = pisteRepository;
    }
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }
    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }
    @Override
    public void deletePiste(long id) {
        pisteRepository.deleteById(id);
    }
    @Override
    public Piste retrivePiste(long id) {
        return pisteRepository.findById(id).orElseThrow();
    }
    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }
}
