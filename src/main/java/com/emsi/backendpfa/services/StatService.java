package com.emsi.backendpfa.services;


import com.emsi.backendpfa.dao.CapteurMesureRepository;
import com.emsi.backendpfa.dao.CapteurRepository;
import com.emsi.backendpfa.entities.CapteurMesure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import java.util.List;

@Service
@Transactional
public class StatService {

    @Autowired
    CapteurMesureRepository capteurMesureRepository;

    @PersistenceUnit
    private EntityManagerFactory emf;

    public List<Object> getDataParRegion(long id)
    {

        return  capteurMesureRepository.getDataParregion(id);

    }
}
