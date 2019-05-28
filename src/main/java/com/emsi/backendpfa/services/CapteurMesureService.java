package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.CapteurMesureRepository;
import com.emsi.backendpfa.entities.Capteur;
import com.emsi.backendpfa.entities.CapteurMesure;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional

public class CapteurMesureService {

    @Autowired
    private CapteurMesureRepository capteurMesureRepository;


    public List<Capteur> saveCSV(String data) {

        return null;
    }
}

