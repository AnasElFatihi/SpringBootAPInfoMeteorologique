package com.emsi.backendpfa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ville_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @JsonIgnore
    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    private List<Region> regions = new ArrayList<>();

    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,  mappedBy = "ville")
    @MapKey(name = "id")
    private Map<UUID, Region> regions = new HashMap<>();

     */
    /*
    @OneToMany (mappedBy = "ville")
    //private Set<Region> regions =  new HashSet<>();
    private Set<Region> regions = new HashSet<>();
    */
    /*
    @JsonIgnore
    @OneToMany(mappedBy="ville")
    private Set<Region> regions;
     */
}
