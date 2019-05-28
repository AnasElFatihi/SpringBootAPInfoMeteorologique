package com.emsi.backendpfa.dao;

import com.emsi.backendpfa.entities.CapteurMesure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CapteurMesureRepository extends JpaRepository<CapteurMesure,Long>, Serializable {
}
