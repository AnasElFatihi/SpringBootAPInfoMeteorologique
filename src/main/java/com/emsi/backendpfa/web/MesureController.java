package com.emsi.backendpfa.web;

import com.emsi.backendpfa.dao.CapteurRepository;
import com.emsi.backendpfa.dao.MesureRepository;
import com.emsi.backendpfa.entities.Capteur;
import com.emsi.backendpfa.entities.Mesure;
import com.emsi.backendpfa.entities.Ville;
import com.emsi.backendpfa.services.CapteurService;
import com.emsi.backendpfa.services.MesureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesures")
public class MesureController {



    @Autowired
    private MesureService mesureService;

    @GetMapping("/all")
    public List<Mesure> getAll(){
        return mesureService.getAll();
    }

    @PostMapping("/capteurs")
    public Mesure saveCapteur(@RequestBody Mesure mesure){

        return mesureService.savemesure(mesure);
    }
    @DeleteMapping("/{id}")
    public void deletecapteur(@PathVariable long  id){
        mesureService.deleteMesure(id);
    }


    @GetMapping("/{id}")
    public Mesure getMesure(@PathVariable long id){
        return mesureService.findById(id);
    }

    @PutMapping("/{id}")
    public Mesure updateMesure(@RequestBody Mesure mesure, @PathVariable long id)
    {

        return mesureService.updateMesure(mesure,id);
    }
}
