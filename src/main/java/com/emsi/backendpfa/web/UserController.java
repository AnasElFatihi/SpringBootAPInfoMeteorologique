package com.emsi.backendpfa.web;

import com.emsi.backendpfa.entities.AppUser;
import com.emsi.backendpfa.entities.Region;
import com.emsi.backendpfa.entities.Ville;
import com.emsi.backendpfa.services.AccountService;
import com.emsi.backendpfa.services.AccountServiceImpl;
import com.emsi.backendpfa.services.RegionService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@RestController
@RequestMapping("/appUsers")
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountServiceImpl accountServiceimpl;

    @Autowired
    private RegionService regionService;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm user){
        return accountService.saveUser(user.getUsername(),user.getPassword(),user.getRepassword());
    }

    @GetMapping("/all")
    public List<AppUser> getAll(){
        return accountServiceimpl.getAll();
    }


    @GetMapping("/{id}")
    public AppUser getUser(@PathVariable long id){
        return accountServiceimpl.findById(id);   //
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


    @PostMapping("/registerresponsable/{id}")
    public AppUser registerResponsable(@RequestBody UserForm user, @PathVariable long id){
        return accountService.saveUserR(user.getUsername(),user.getPassword(),user.getRepassword(),id);
    }

    @GetMapping("/getregion/{id}")
    public Region getUserRegion(@PathVariable String id){
        return accountServiceimpl.loadRegion(id);   //
    }

}

@Data
class UserForm{
    private String username;
    private String password;
    private String repassword;


}
