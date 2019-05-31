package com.emsi.backendpfa.web;

import com.emsi.backendpfa.dao.RegionRepository;
import com.emsi.backendpfa.entities.Region;
import com.emsi.backendpfa.entities.Ville;
import com.emsi.backendpfa.services.RegionService;
import com.emsi.backendpfa.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private RegionService regionService;
    @Autowired
    private VilleService villeService;

    @GetMapping("/all")
    public List<Region> getAll(){
        return regionService.getAll();
    }

    @GetMapping("/{id}")
    public Region getRegion(@PathVariable long id){
        return regionService.findById(id);
    }

    @PostMapping("/{id}")
    public Region saveRegion(@RequestBody Region region, @PathVariable long  id){
        Ville ville = villeService.findById(id);
        region.setVille(ville);
        System.out.println(region.getVille());
        return regionService.saveRegion(region);

    }

    @PutMapping("/{id}")
    public Region updateRegion(@RequestBody Region region, @PathVariable long id)
    {
        return regionService.updateRegion(region,id);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable long  id){
        regionService.deleteRegion(id);
    }
    @GetMapping("/anas")
    public Region gettest(){
        return regionRepository.findById((long)1).get();
    }
}
