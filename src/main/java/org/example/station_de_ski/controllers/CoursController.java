package org.example.station_de_ski.controllers;
import org.example.station_de_ski.entites.Cours;
import org.example.station_de_ski.services.interfaces.ICoursService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cour")
public class CoursController {
    private final ICoursService coursService;
    public CoursController(ICoursService coursService) {
        this.coursService = coursService;
    }
    @GetMapping("/allcours")
    public List<Cours> retriveAllCourses() {
        return coursService.retriveAllCourses();
    }
    @GetMapping("/{id}")
    public Cours retriveCours( long id) {
        return coursService.retriveCours(id);
    }
    @PostMapping("/addcours")
    public Cours addCours( Cours cours) {
        return coursService.addCours(cours);
    }
    @PutMapping("/updatecours")
    public Cours updateCours( Cours cours) {
        return coursService.updateCours(cours);
    }
    @DeleteMapping("/deletecours/{id}")
    public void deleteCours(@PathVariable long id) {
        coursService.deleteCours(id);
    }
}
