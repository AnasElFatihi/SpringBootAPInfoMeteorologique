package com.emsi.backendpfa.web;

import com.emsi.backendpfa.dao.CapteurRepository;
import com.emsi.backendpfa.dao.VilleRepository;
import com.emsi.backendpfa.entities.Capteur;
import com.emsi.backendpfa.entities.Region;
import com.emsi.backendpfa.entities.Ville;
import com.emsi.backendpfa.services.CapteurService;
import com.emsi.backendpfa.services.RegionService;
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

    @Autowired
    private RegionService regionService;

    @GetMapping("/all")
    public List<Capteur> getAll(){
        return capteurService.getAll();
    }

    @GetMapping("/{id}")
    public Capteur getCapteur(@PathVariable long id){
        return capteurService.findById(id);
    }

    @PostMapping("/{idcapt}")
    public Capteur saveCapteur(@RequestBody Capteur capteur, @PathVariable long idcapt){
        Region region = regionService.findById(idcapt);
        capteur.setRegion(region);
        capteurService.saveCapteur(capteur);
        return capteurService.findById(capteur.getIdcapt());
    }

    @PutMapping("/{idcapt}")
    public Capteur updateCapteur(@RequestBody Capteur capteur, @PathVariable long idcapt)
    {
        return capteurService.updateCapteur(capteur,idcapt);
    }

    @DeleteMapping("/{idcapt}")
    public void deletecapteur(@PathVariable long  idcapt){
        capteurService.deleteCapteur(idcapt);
    }

}
