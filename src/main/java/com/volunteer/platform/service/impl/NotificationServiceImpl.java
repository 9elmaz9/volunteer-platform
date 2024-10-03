package com.volunteer.platform.service.impl;

import com.volunteer.platform.model.Notification;
import com.volunteer.platform.model.User;
import com.volunteer.platform.repository.NotificationRepository;
import com.volunteer.platform.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void sendNotification(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsForUser(User user) {
        return notificationRepository.findByUser(user);
    }

    @Override
    public void deleteNotification(Notification notification) {
        notificationRepository.delete(notification);
    }
}
