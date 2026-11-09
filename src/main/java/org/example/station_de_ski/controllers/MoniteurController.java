package org.example.station_de_ski.controllers;
import org.example.station_de_ski.entites.Moniteur;
import org.example.station_de_ski.services.interfaces.IMoniteurService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/moniteur")
public class MoniteurController {
    private final IMoniteurService moniteurService;
    public MoniteurController(IMoniteurService moniteurService) {
        this.moniteurService = moniteurService;
    }
    @GetMapping("/allmoniteurs")
    public List<Moniteur>retriveAllMoniteurs() {
        return moniteurService.retriveAllMoniteurs();
    }
    @GetMapping("/{id}")
    public Moniteur retriveMoniteur(@PathVariable long id) {
        return moniteurService.retriveMoniteur(id);
    }
    @PostMapping("/addmoniteur")
    public Moniteur addMoniteur( @RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }
    @PutMapping("/updatemoniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMoniteur(@PathVariable long id) {
        moniteurService.deleteMoniteur(id);
    }
}
