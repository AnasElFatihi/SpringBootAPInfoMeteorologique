package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.AppUserRepository;
import com.emsi.backendpfa.dao.RegionRepository;
import com.emsi.backendpfa.dao.VilleRepository;
import com.emsi.backendpfa.entities.Region;
import com.emsi.backendpfa.entities.Region;
import com.emsi.backendpfa.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    VilleService villeService = new VilleService();

    public Region saveRegion(Region region){
        return regionRepository.save(region);
    }

    public List<Region> getAll(){
        return regionRepository.findAll();
    }

    public  Region findById(long id){

        return regionRepository.findById(id).get();
    }

    public void deleteRegion(long id){
        regionRepository.deleteById(id);
    }

    public Region updateRegion(Region region, long id){
        Region regionEx = regionRepository.getOne(id);
        regionEx.setName(region.getName());

        //regionEx.setVille(region.getVille());

        return regionRepository.findById(regionEx.getId()).get();
    }
/*
    public Region saveRegion(Region region)
    {
        regionRepository.save(region);
        return region;
    }
    public List<Region> getAll(){
        return regionRepository.findAll();
    }

    public Optional<Region> findByID(long id) {
        //return regionRepository.findByNom(name);
        return regionRepository.findById(id);
    }
*/

}
