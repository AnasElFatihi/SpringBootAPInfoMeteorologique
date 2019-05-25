package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.VilleRepository;
import com.emsi.backendpfa.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin

public class VilleService {
    @Autowired
    private VilleRepository villeRepository;


    public Ville saveVille(Ville ville){
        Ville a = new Ville();
        a.setName(ville.getName());
        a.setLongitude(ville.getLongitude());
        a.setLatitude(ville.getLatitude());
        villeRepository.save(a);
        System.out.println(villeRepository.findById(a.getId()).get());
        return a;
    }

    public List<Ville> getAll(){
        return villeRepository.findAll();
    }

    public  Ville findById(long id){

    return villeRepository.findById(id).get();
    }



    public void deleteVille(long id){
        villeRepository.deleteById(id);
    }

    public Ville updateVille(Ville ville, long id){
        Ville villeEx = villeRepository.getOne(id);
        villeEx.setName(ville.getName());
        villeEx.setLatitude(ville.getLatitude());
        villeEx.setLongitude(ville.getLongitude());
        villeEx.setRegions(ville.getRegions());
        villeRepository.save(villeEx);

        return villeEx;
    }
}
