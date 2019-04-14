package com.emsi.backendpfa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    private Collection<Region> regions = new ArrayList<>();

}
