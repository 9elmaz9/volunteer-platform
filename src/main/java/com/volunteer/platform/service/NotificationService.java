package com.volunteer.platform.service;

import com.volunteer.platform.model.Notification;
import com.volunteer.platform.model.User;

import java.util.List;

public interface NotificationService {
    void sendNotification(User user, String message);
    List<Notification> getNotificationsForUser(User user);
    void deleteNotification(Notification notification);
}
