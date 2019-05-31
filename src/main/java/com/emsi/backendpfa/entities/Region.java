package com.emsi.backendpfa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Region  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    /*
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private Collection<AppUser> users = new ArrayList<>();
     */
   // @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @JsonIgnore
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private Set<Capteur> capteurs = new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private Set<AppUser> users = new HashSet<>();

    //@JsonIgnore
    //@OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    //private Set<Capteur> capteurs = new HashSet<>();
    /*
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonIgnore
    private Ville ville;

     */
    /*
    @ManyToOne
    @JoinColumn(name="ville_id", nullable=false)
    private Ville ville;
    */
}
