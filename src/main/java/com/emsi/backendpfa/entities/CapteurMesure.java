package com.emsi.backendpfa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "CapteursMesures")
public class CapteurMesure {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;



        @Column
        private double valeur;
        @Column
        private Date date;


        @ManyToOne
        @JoinColumn(name = "capteur_id")
        private Capteur capteur;

        @ManyToOne
        @JoinColumn(name = "mesure_id")
        private Mesure mesure;




}
