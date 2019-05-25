package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.MesureRepository;
import com.emsi.backendpfa.entities.Capteur;
import com.emsi.backendpfa.entities.Mesure;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MesureService {

    @Autowired
    MesureRepository mesureRepository;


    public Mesure savemesure(Mesure m){

        return  mesureRepository.save(m);

    }


    public List<Mesure> getAll() {

        return mesureRepository.findAll();
    }

    public void deleteMesure(long id) {
        mesureRepository.deleteById(id);
    }

    public Mesure findById(long id) {
        return mesureRepository.findById(id).get();
    }

    public Mesure updateMesure(Mesure mesure, long id) {

        Mesure m = mesureRepository.getOne(id);
        m.setMesure(mesure.getMesure());
        m.setTypevaleur(mesure.getTypevaleur());
        return mesureRepository.save(m);

    }
}
