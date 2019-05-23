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

    @ManyToMany(fetch = FetchType.LAZY,
               cascade = {
        CascadeType.PERSIST,
                CascadeType.MERGE
    },
    mappedBy = "capteurs")
    private Set<Mesure> mesures = new HashSet<>();


    public long getIdcapt() {
        return idcapt;
    }

    public void setIdcapt(long idcapt) {
        this.idcapt = idcapt;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDateinstall() {
        return dateinstall;
    }

    public void setDateinstall(String dateinstall) {
        this.dateinstall = dateinstall;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
