package com.emsi.backendpfa.dao;

import com.emsi.backendpfa.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;
@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville,Long>, Serializable {

}
