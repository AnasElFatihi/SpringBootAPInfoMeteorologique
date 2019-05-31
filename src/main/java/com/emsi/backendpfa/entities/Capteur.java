package com.emsi.backendpfa.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Capteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcapt;
    private String libelle;
    private String etat;
    private String dateinstall ;
    private String marque;

    //@JoinColumn
    //private  String region;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;



    @JsonIgnore
    @OneToMany(mappedBy = "capteur",cascade = CascadeType.ALL)
    private Set<CapteurMesure> capteursmesures = new HashSet<>();



}
