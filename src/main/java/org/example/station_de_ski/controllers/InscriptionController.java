package org.example.station_de_ski.controllers;
import org.example.station_de_ski.entites.AssignRegistrationDTO;
import org.example.station_de_ski.entites.Inscription;
import org.example.station_de_ski.services.interfaces.IInscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/inscription")
public class InscriptionController {
    private final IInscriptionService inscriptionService;
    public InscriptionController(IInscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }
    @GetMapping("/allinscriptions")
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }
   @GetMapping("/{id}")
    public Inscription getInscription(@PathVariable long id) {
        return inscriptionService.getInscription(id);
    }
    @PostMapping("/addinscription")
    public Inscription addInscription( Inscription inscription) {
        return inscriptionService.addInscription(inscription);
    }
    @PutMapping("/updateinscription")
    public Inscription updateInscription( Inscription inscription) {
        return inscriptionService.updateInscription(inscription);
    }
    @DeleteMapping("/deleteinscription/{id}")
    public void deleteInscription(@PathVariable long id) {
        inscriptionService.deleteInscription(id);
    }

    @PostMapping("/add/{numSkieur}")
    public ResponseEntity<Inscription> addInscriptionAndAssignToSkieur(@RequestBody Inscription inscription, @PathVariable Long numSkieur) {

        Inscription created = inscriptionService.addInscriptionAndAssignToSkieur(inscription, numSkieur);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/assign")
    public ResponseEntity<Inscription> assignRegistrationToCourse(
            @RequestBody AssignRegistrationDTO dto) {

        Inscription inscription =
                inscriptionService.assignRegistrationToCourse(
                        dto.getNumRegistration(),
                        dto.getNumCourse()
                );

        return ResponseEntity.ok(inscription);
    }

}
