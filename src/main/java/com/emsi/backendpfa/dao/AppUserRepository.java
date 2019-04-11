package com.emsi.backendpfa.dao;

import com.emsi.backendpfa.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser,Long>, Serializable {

    public AppUser findByUsername(String username);



}
