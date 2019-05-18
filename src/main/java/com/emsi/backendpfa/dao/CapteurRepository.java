package com.emsi.backendpfa.dao;

import com.emsi.backendpfa.entities.Capteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;
@RepositoryRestResource
public interface CapteurRepository extends JpaRepository<Capteur,Long>, Serializable {

}
