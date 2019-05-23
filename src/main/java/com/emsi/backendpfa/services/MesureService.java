package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.MesureRepository;
import com.emsi.backendpfa.entities.Capteur;
import com.emsi.backendpfa.entities.Mesure;
import org.springframework.beans.factory.annotation.Autowired;

public class MesureService {

    @Autowired
    MesureRepository mesureRepository;


    public Mesure savemesure(){
        Mesure m = new Mesure();
        m.setMesure("temperature");
        m.setTypevaleur("number");
        mesureRepository.save(m);
        return m;
    }


}
