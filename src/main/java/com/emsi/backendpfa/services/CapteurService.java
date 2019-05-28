package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.CapteurRepository;
import com.emsi.backendpfa.dao.VilleRepository;
import com.emsi.backendpfa.entities.Capteur;
import com.emsi.backendpfa.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin

public class CapteurService {
    @Autowired
    private CapteurRepository capteurRepository;


    public Capteur saveCapteur(Capteur capteur){
       /* Capteur a = new Capteur();
        a.setLibelle(capteur.getLibelle());
        a.setEtat(capteur.getEtat());
        a.setDateinstall(capteur.getDateinstall());
        a.setMarque(capteur.getMarque());
        a.setRegion(capteur.getRegion());
        capteurRepository.save(a);
        System.out.println(capteurRepository.findById(a.getIdcapt()).get());
        return a;
        */
        return capteurRepository.save(capteur);

    }

    public List<Capteur> getAll(){
        return capteurRepository.findAll();
    }

    public  Capteur findById(long idcapt){

        return capteurRepository.findById(idcapt).get();
    }

    public void deleteCapteur(long id){
        capteurRepository.deleteById(id);
    }

    public Capteur updateCapteur(Capteur capteur, long id){
       /*
        Capteur capteurEx = capteurRepository.getOne(id);
        capteurEx.setLibelle(capteur.getLibelle());
        capteurEx.setEtat(capteur.getEtat());
        capteurEx.setDateinstall(capteur.getDateinstall());
        capteurEx.setMarque(capteur.getMarque());
        capteurEx.setRegion(capteur.getRegion());
        return capteurEx;
        */
        Capteur capteurEx = capteurRepository.getOne(id);
        capteurEx.setLibelle(capteur.getLibelle());
        capteurEx.setEtat(capteur.getEtat());
        capteurEx.setDateinstall(capteur.getDateinstall());
        capteurEx.setMarque(capteur.getMarque());
        capteurEx.setRegion(capteur.getRegion());

        //regionEx.setVille(region.getVille());
        capteurRepository.save(capteurEx);
        System.out.println(capteurRepository.findById(capteurEx.getIdcapt()).get());
        return capteurEx;
    }
}
