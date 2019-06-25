package com.emsi.backendpfa.dao;


import com.emsi.backendpfa.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;


@RepositoryRestResource
public interface RegionRepository extends JpaRepository<Region,Long>, Serializable {

    Region findByName(String a);

}
