package com.emsi.backendpfa.services;

import com.emsi.backendpfa.entities.AppRole;
import com.emsi.backendpfa.entities.AppUser;

public interface AccountService

{
    public AppUser saveUser( String username,String password,String confirmedPassword);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);


}
