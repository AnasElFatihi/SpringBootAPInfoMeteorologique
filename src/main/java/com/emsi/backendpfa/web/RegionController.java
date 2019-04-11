package com.emsi.backendpfa.web;

import com.emsi.backendpfa.dao.AppRoleRepository;
import com.emsi.backendpfa.dao.AppUserRepository;
import com.emsi.backendpfa.dao.RegionRepository;
import com.emsi.backendpfa.entities.AppUser;
import com.emsi.backendpfa.entities.Region;
import com.emsi.backendpfa.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private AppUserRepository appUserRepository;
    @GetMapping(value="/all")
    public List<Region> getAll(){
        return regionService.getAll();
    }

    @GetMapping(value="/test")
    public Region hello(){
        System.out.println("hi");
        Region a = new Region(  );
        regionRepository.save(a);
        Region  region = regionRepository.findById(Long.valueOf(1)).get();
        System.out.println(region);
        List<AppUser> users = appUserRepository.findAll();
        System.out.println(users);
        region.setUsers(users);


        return region;
    }

    @PostMapping("/regions")
    public Optional<Region> saveRegion(@RequestBody final Region  region)
    {
         regionService.saveRegion(region);
         return regionService.findByID(region.getId());
    }

}
