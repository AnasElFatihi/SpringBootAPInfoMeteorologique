package com.emsi.backendpfa.dao;

import com.emsi.backendpfa.entities.Mesure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface MesureRepository extends JpaRepository<Mesure,Long>, Serializable {

}
