package com.emsi.backendpfa.web;

import com.emsi.backendpfa.dao.VilleRepository;
import com.emsi.backendpfa.entities.Ville;
import com.emsi.backendpfa.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/villes")
public class VilleController {

    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private VilleService villeService;

    @GetMapping("/all")
    public List<Ville> getAll(){
        return villeService.getAll();
    }

    @PostMapping("/villes/id")
    public Optional<Ville> saveVille(@RequestBody Ville ville){
        villeService.saveVille(ville);
        return villeService.findById(ville.getId());
    }
    @PutMapping("/villes/id")
    public void updateVille(@RequestBody Ville ville, long id){
        villeService.updateVille(ville,id);
    }

    @DeleteMapping("/villes/id")
    public void deleteVille(long id){
        villeService.deleteVille(id);
    }

}
