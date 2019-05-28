package com.emsi.backendpfa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String message;

    @Column
    private double seuilmin;


    @Column
    private String seuilmax;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mesure_id")
    private Mesure mesure;
}
