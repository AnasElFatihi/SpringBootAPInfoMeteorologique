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

    @GetMapping("/{id}")
    public Ville getVille(@PathVariable long id){
        return villeService.findById(id);
    }
    @PostMapping("/villes")
    public Ville saveVille(@RequestBody Ville ville){

        villeService.saveVille(ville);
        return villeService.findById(ville.getId());
    }
    @PutMapping("/{id}")
    public Ville updateVille(@RequestBody Ville ville, @PathVariable long id)
    {
        return villeService.updateVille(ville,id);
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable long  id){
        villeService.deleteVille(id);
    }

}
