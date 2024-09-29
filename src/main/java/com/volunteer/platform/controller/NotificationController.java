package com.volunteer.platform.controller;

import com.volunteer.platform.model.Notification;
import com.volunteer.platform.model.User;
import com.volunteer.platform.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody Notification notification) {
        notificationService.sendNotification(notification.getUser(), notification.getMessage());
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsForUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return notificationService.getNotificationsForUser(user);
    }

    @DeleteMapping("/{notificationId}")
    public void deleteNotification(@PathVariable Long notificationId) {
        Notification notification = new Notification();
        notification.setId(notificationId);
        notificationService.deleteNotification(notification);
    }
}
