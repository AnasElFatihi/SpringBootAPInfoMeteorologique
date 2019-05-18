package com.emsi.backendpfa.web;

import com.emsi.backendpfa.dao.CapteurRepository;
import com.emsi.backendpfa.dao.VilleRepository;
import com.emsi.backendpfa.entities.Capteur;
import com.emsi.backendpfa.entities.Ville;
import com.emsi.backendpfa.services.CapteurService;
import com.emsi.backendpfa.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/capteurs")
public class CapteurController {

    @Autowired
    private CapteurRepository capteurRepository;

    @Autowired
    private CapteurService capteurService;

    @GetMapping("/all")
    public List<Capteur> getAll(){
        return capteurService.getAll();
    }

    @PostMapping("/capteurs")
    public Capteur saveCapteur(@RequestBody Capteur capteur){

        capteurService.saveCapteur(capteur);
        return capteurService.findById(capteur.getIdcapt());
    }
    @PutMapping("/capteurs/{idcapt}")
    public Capteur updateCapteur(@RequestBody Capteur capteur, @PathVariable long id)
    {
        return capteurService.updateCapteur(capteur,id);
    }

    @DeleteMapping("/capteurs/{idcapt}")
    public void deletecapteur(@PathVariable long  idcapt){
        capteurService.deleteCapteur(idcapt);
    }

}
