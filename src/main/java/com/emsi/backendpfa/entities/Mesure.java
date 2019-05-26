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
public class Mesure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mesure;
    private String typevaleur;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(joinColumns = { @JoinColumn(name = "mesure_id") },
            inverseJoinColumns = { @JoinColumn(name = "capteur_id") })
    private Set<Capteur> capteurs = new HashSet<>();
}
