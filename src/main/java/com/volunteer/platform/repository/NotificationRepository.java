package com.volunteer.platform.repository;

import com.volunteer.platform.model.Notification;
import com.volunteer.platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUser(User user);
}
