package com.emsi.backendpfa.web;


import com.emsi.backendpfa.entities.Notification;
import com.emsi.backendpfa.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")


public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/all/{id}")
    public List<Notification> getAll(@PathVariable long id){
        return notificationService.getAll(id);
    }

    @PostMapping("/{id}")
    public Notification save(@RequestBody Notification n,@PathVariable long id){
        return notificationService.addNotification(n,id);
    }

    @DeleteMapping("/{id}")
    public void deleteNotif(@PathVariable long  id){
        notificationService.deleteMesure(id);
    }

    @GetMapping("/{id}")
    public Notification getOne(@PathVariable long id){
        return notificationService.getOne(id);
    }

    @PutMapping("/{id}/{idmesure}")
    public Notification modifier(@RequestBody Notification n,@PathVariable long id,@PathVariable long idmesure){
        return notificationService.modifier(n,id,idmesure);
    }

}
