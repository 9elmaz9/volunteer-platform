package com.volunteer.platform.repository;

import com.volunteer.platform.model.Subscription;
import com.volunteer.platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByFollower(User follower);
    List<Subscription> findByFollowee(User followee);
}
