package com.emsi.backendpfa.web;

import com.emsi.backendpfa.entities.AppUser;
import com.emsi.backendpfa.services.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm user){
        return accountService.saveUser(user.getUsername(),user.getPassword(),user.getRepassword());
    }

}

@Data
class UserForm{
    private String username;
    private String password;
    private String repassword;
}