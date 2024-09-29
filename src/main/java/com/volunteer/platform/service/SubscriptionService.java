package com.volunteer.platform.service;

import com.volunteer.platform.model.Subscription;
import com.volunteer.platform.model.User;

import java.util.List;

public interface SubscriptionService {
    void subscribe(User follower, User followee);
    void unsubscribe(User follower, User followee);
    List<Subscription> getSubscriptionsForUser(User user);
    void deleteSubscription(Subscription subscription);
}
