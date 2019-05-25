package com.emsi.backendpfa.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Capteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcapt;
    private String libelle;
    private String etat;
    private String dateinstall ;
    private String marque;

    // @ManyToOne
    @JoinColumn
    private  String region;



    @OneToMany(mappedBy = "capteur")
    private Set<CapteurMesure> joined = new HashSet<>();



}
