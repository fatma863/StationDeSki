package org.example.station_de_ski.controllers;
import org.example.station_de_ski.entites.Piste;
import org.example.station_de_ski.services.interfaces.IPisteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/piste")
public class PisteController {
    private final IPisteService pisteService;
    public PisteController(IPisteService pisteService) {
        this.pisteService = pisteService;
    }
    @GetMapping("/allpistes")
    public List<Piste> retrieveAllPistes() {
        return pisteService.retrieveAllPistes();
    }

    @GetMapping("/{id}")
    public Piste retrievePiste(@PathVariable long id) {
        return pisteService.retrivePiste(id);
    }

    @PostMapping("/addpiste")
    public Piste addPiste( Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping("/updatepiste")
    public Piste updatePiste( Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePiste(@PathVariable long id) {
        pisteService.deletePiste(id);
    }

}
