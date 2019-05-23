package com.emsi.backendpfa.web;

import com.emsi.backendpfa.entities.AppUser;
import com.emsi.backendpfa.entities.Ville;
import com.emsi.backendpfa.services.AccountService;
import com.emsi.backendpfa.services.AccountServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appUsers")
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountServiceImpl accountServiceimpl;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm user){
        return accountService.saveUser(user.getUsername(),user.getPassword(),user.getRepassword());
    }

    @GetMapping("/all")
    public List<AppUser> getAll(){
        return accountServiceimpl.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long  id){
        accountServiceimpl.deleteUser(id);
    }

    @PutMapping("/{id}")
    public AppUser updateUser(@RequestBody AppUser user, @PathVariable long id)
    {

        return accountServiceimpl.updateUser(user,id);
    }

    @GetMapping("/{id}")
    public AppUser getUser(@PathVariable long id){
        return accountServiceimpl.findById(id);   //
    }

    @PostMapping("/registerresponsable")
    public AppUser registerResponsable(@RequestBody UserForm user){
        return accountService.saveUserR(user.getUsername(),user.getPassword(),user.getRepassword());
    }
}

@Data
class UserForm{
    private String username;
    private String password;
    private String repassword;
}
