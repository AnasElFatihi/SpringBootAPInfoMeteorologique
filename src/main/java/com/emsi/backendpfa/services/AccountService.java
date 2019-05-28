package com.emsi.backendpfa.services;

import com.emsi.backendpfa.entities.AppRole;
import com.emsi.backendpfa.entities.AppUser;

import java.util.List;

public interface AccountService

{
    public AppUser saveUser( String username,String password,String confirmedPassword);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);


    List<AppUser> getAll();

    AppUser saveUserR(String username, String password, String repassword, long id);
}
