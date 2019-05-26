package com.emsi.backendpfa.dao;


import com.emsi.backendpfa.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long>, Serializable {


    @Query( value="select * from notification n where mesure_id= ?1",nativeQuery = true)
    List<Notification> getNotifications(long id);



}
