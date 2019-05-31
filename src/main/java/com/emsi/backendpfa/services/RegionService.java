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
        regionEx.setCapteurs(region.getCapteurs());
        regionEx.setVille(region.getVille());
        regionRepository.save(regionEx);

        return regionEx;
    }


}
