package com.emsi.backendpfa.services;

import com.emsi.backendpfa.dao.MesureRepository;
import com.emsi.backendpfa.dao.NotificationRepository;
import com.emsi.backendpfa.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private MesureRepository mesureRepository;

    public List<Notification> getAll( long id) {
        return notificationRepository.getNotifications(id);
    }

    public Notification addNotification(Notification n, long id) {
        n.setMesure(mesureRepository.findById(id).get());
        return notificationRepository.save(n);
    }

    public void deleteMesure(long id) {
        notificationRepository.delete(notificationRepository.findById(id).get());
    }

    public Notification getOne(long id) {
        return notificationRepository.findById(id).get();
    }

    public Notification modifier(Notification n, long id,long idmesure) {
        Notification m = notificationRepository.findById(id).get();
        m.setMesure(mesureRepository.findById(idmesure).get());
        m.setMessage(n.getMessage());
        m.setSeuilmax(n.getSeuilmax());
        m.setSeuilmin(n.getSeuilmin());
        return notificationRepository.save(m);

    }
}
