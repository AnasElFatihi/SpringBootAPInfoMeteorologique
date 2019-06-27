package com.emsi.backendpfa.web;

import com.emsi.backendpfa.services.MesureService;
import com.emsi.backendpfa.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stats")

public class StatsController  {

    @Autowired
    private StatService statService;


    @GetMapping("/{id}")
    public List getDataRegion(@PathVariable long id)
    {
        //return new ArrayList();
        return  statService.getDataParRegion(id);
    }

    @GetMapping("/allregions")
    public List getAllData(){
        return statService.getAlldata();
    }
    @GetMapping("/regions/{id}")
    public List getRegionCapteurs(@PathVariable long id){
        return statService.getRegionCapteurs(id);
    }
}
