package com.emsi.backendpfa;

import com.emsi.backendpfa.entities.*;
import com.emsi.backendpfa.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendpfaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendpfaApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    /*
    @Bean
    CommandLineRunner start(AccountService accountService,MesureService mesureService,RegionService regionService,VilleService villeService,
                            CapteurService capteurService){


        return args->{
            accountService.save( new AppRole(1,"USER"));
            accountService.save( new AppRole(2,"ADMIN"));
            accountService.save( new AppRole(3,"RESPONSABLE"));
            //mesureService.savemesure();


            //mesureService.savemesure(new Mesure("Temperature","nombre"));

            Stream.of("user1","user2","user3","admin").forEach( un -> {
                accountService.saveUser(un ,"1234","1234");

            });
            accountService.addRoleToUser("admin","ADMIN");



        };
    }*/
}
