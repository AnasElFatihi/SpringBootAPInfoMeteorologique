package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.AppUserRepository;
import com.emsi.backendpfa.dao.RegionRepository;
import com.emsi.backendpfa.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;




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
}
