package com.volunteer.platform.controller;

import com.volunteer.platform.model.Subscription;
import com.volunteer.platform.model.User;
import com.volunteer.platform.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public void subscribe(@RequestParam Long followerId, @RequestParam Long followeeId) {
        User follower = new User();
        follower.setId(followerId);
        User followee = new User();
        followee.setId(followeeId);
        subscriptionService.subscribe(follower, followee);
    }

    @DeleteMapping
    public void unsubscribe(@RequestParam Long followerId, @RequestParam Long followeeId) {
        User follower = new User();
        follower.setId(followerId);
        User followee = new User();
        followee.setId(followeeId);
        subscriptionService.unsubscribe(follower, followee);
    }

    @GetMapping("/user/{userId}")
    public List<Subscription> getSubscriptionsForUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return subscriptionService.getSubscriptionsForUser(user);
    }

    @DeleteMapping("/{subscriptionId}")
    public void deleteSubscription(@PathVariable Long subscriptionId) {
        Subscription subscription = new Subscription();
        subscription.setId(subscriptionId);
        subscriptionService.deleteSubscription(subscription);
    }
}
