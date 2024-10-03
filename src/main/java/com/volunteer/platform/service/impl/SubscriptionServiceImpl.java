package com.volunteer.platform.service.impl;

import com.volunteer.platform.model.Subscription;
import com.volunteer.platform.model.User;
import com.volunteer.platform.repository.SubscriptionRepository;
import com.volunteer.platform.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public void subscribe(User follower, User followee) {
        Subscription subscription = new Subscription();
        subscription.setFollower(follower);
        subscription.setFollowee(followee);
        subscriptionRepository.save(subscription);
    }

    @Override
    public void unsubscribe(User follower, User followee) {
        List<Subscription> subscriptions = subscriptionRepository.findByFollower(follower);
        subscriptions.stream()
                .filter(subscription -> subscription.getFollowee().equals(followee))
                .findFirst()
                .ifPresent(subscriptionRepository::delete);
    }

    @Override
    public List<Subscription> getSubscriptionsForUser(User user) {
        return subscriptionRepository.findByFollower(user);
    }

    @Override
    public void deleteSubscription(Subscription subscription) {
        subscriptionRepository.delete(subscription);
    }
}
