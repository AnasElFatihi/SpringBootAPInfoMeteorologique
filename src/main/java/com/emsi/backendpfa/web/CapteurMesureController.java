package com.emsi.backendpfa.web;


import com.emsi.backendpfa.dao.CapteurMesureRepository;
import com.emsi.backendpfa.dao.CapteurRepository;
import com.emsi.backendpfa.dao.MesureRepository;
import com.emsi.backendpfa.entities.Capteur;
import com.emsi.backendpfa.entities.CapteurMesure;
import com.emsi.backendpfa.entities.Notification;
import com.emsi.backendpfa.services.CapteurMesureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/capteursmesures")
public class CapteurMesureController {

    @Autowired
    private CapteurRepository capteurRepository;

    @Autowired
    private MesureRepository mesureRepository;

    @Autowired
    private CapteurMesureRepository capteurMesureRepository;

    @PostMapping
     public List<Notification> saveCSV(@RequestBody String data) throws ParseException {

        JSONObject jsonObj = new JSONObject(data);
        JSONArray a = (JSONArray) jsonObj.get("data");


        List<Notification> maliste = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            JSONObject j = (JSONObject) a.get(i);

            CapteurMesure c = new CapteurMesure();
            DateFormat df = new SimpleDateFormat("dd-mm-yyyy", Locale.FRANCE);
            Date result = df.parse(j.getString("date"));
            c.setDate(result);
            c.setValeur(j.getDouble("valeur"));
            c.setMesure(mesureRepository.findById(j.getLong("idmesure")).get());
            c.setCapteur(capteurRepository.findById(j.getLong("idcapteur")).get());
            capteurMesureRepository.save(c);


            for (Notification n : c.getMesure().getNotifications()) {
                String message = n.getMessage();
                Double seuilmin = n.getSeuilmin();
                Double seuilmax = n.getSeuilmax();

                if (c.getValeur() < seuilmin || c.getValeur() > seuilmax)
                    maliste.add(n);

            }

        }
        return maliste;
    }
}

@Data
class CSV{
    private Long idcapt;
    private long idmesure;
    private Date date;
    private double valeur;
}

