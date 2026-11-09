package org.example.station_de_ski.services.interfaces;
import org.example.station_de_ski.entites.Piste;

import java.util.List;

public interface IPisteService {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    void deletePiste(long id);
    Piste retrivePiste(long id);
    List<Piste> retrieveAllPistes();
}
