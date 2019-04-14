package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.VilleRepository;
import com.emsi.backendpfa.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VilleService {
    @Autowired
    private VilleRepository villeRepository;


    public Ville saveVille(Ville ville){
        villeRepository.save(ville);
        return ville;
    }

    public List<Ville> getAll(){
        return villeRepository.findAll();
    }

    public Optional <Ville> findById(long id){
        return villeRepository.findById(id);
    }

    public void deleteVille(long id){
        villeRepository.deleteById(id);
    }

    public void updateVille(Ville ville, long id){
        Ville villeEx = villeRepository.getOne(id);
        villeEx.setName(ville.getName());
        villeEx.setLatitude(ville.getLatitude());
        villeEx.setLongitude(ville.getLongitude());
        villeEx.setRegions(ville.getRegions());
        villeRepository.save(villeEx);
    }
}
