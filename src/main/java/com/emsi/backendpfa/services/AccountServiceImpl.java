package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.AppRoleRepository;
import com.emsi.backendpfa.dao.AppUserRepository;
import com.emsi.backendpfa.entities.AppRole;
import com.emsi.backendpfa.entities.AppUser;
import com.emsi.backendpfa.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword) {
        AppUser user = appUserRepository.findByUsername(username);
        if( user != null)
            throw new RuntimeException("User Already Exists");
        if ( ! password.equals(confirmedPassword))
            throw new RuntimeException(("les mots de passes ne correspondent pas !"));
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setActived(true);

        appUserRepository.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);

    }

    @Override
    public List<AppUser> getAll(){

        return appUserRepository.findAll();
    }

    public void deleteUser(long id) {

        appUserRepository.deleteById(id);
    }

    public AppUser updateUser(AppUser user, long id) {


            AppUser villeEx = appUserRepository.getOne(id);
            villeEx.setUsername(user.getUsername());
            if( user.getPassword() != "")
            {
                villeEx.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                System.out.println(user.getPassword());
            }

            //villeEx.setRegions(viluserle.getRegions());
        appUserRepository.save(villeEx);
        System.out.println(villeEx);
            return villeEx;

    }

    public AppUser findById(long id) {

        return appUserRepository.findById(id).get();
    }

    @Override
    public AppUser saveUserR(String username, String password, String confirmedPassword) {
        AppUser user = appUserRepository.findByUsername(username);
        if( user != null)
            throw new RuntimeException("User Already Exists");
        if ( ! password.equals(confirmedPassword))
            throw new RuntimeException(("les mots de passes ne correspondent pas !"));
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setActived(true);

        appUserRepository.save(appUser);
        addRoleToUser(username,"RESPONSABLE");
        return appUser;
    }
}
