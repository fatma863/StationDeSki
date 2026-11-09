package org.example.station_de_ski.controllers;
import org.example.station_de_ski.entites.Abonnement;
import org.example.station_de_ski.services.interfaces.IAbonnementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/abonnement")
public class AbonnementController {
    private final IAbonnementService abonnementService;
    public AbonnementController(IAbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }
    @GetMapping("/allabonnement")
    public List<Abonnement> getAllAbonnement() {
        return abonnementService.getAllAbonnement();
    }
    @GetMapping("/{id}")
    public Abonnement getAbonnement(@PathVariable long id) {
        return abonnementService.getAbonnement(id);
    }
    @PostMapping("/addabonnement")
    public Abonnement addAbonnement( @RequestBody Abonnement abonnement) {
        return abonnementService.addAbonnement(abonnement);
    }
    @PutMapping("/updateabonnement")
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.updateAbonnement(abonnement);
    }
    @DeleteMapping("/deleteabonnement/{id}")
    public void deleteAbonnement(@PathVariable long id) {
        abonnementService.deleteAbonnement(id);
    }
}
