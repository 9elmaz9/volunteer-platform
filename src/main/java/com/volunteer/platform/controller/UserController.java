package com.volunteer.platform.controller;

import com.volunteer.platform.model.User;
import com.volunteer.platform.model.Role;
import com.volunteer.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @PutMapping("/profile")
    public void updateProfile(@RequestBody User user) {
        userService.updateProfile(user);
    }

    @PutMapping("/change-password")
    public void changePassword(@RequestParam String email, @RequestParam String newPassword) {
        User user = userService.login(email, newPassword);
        if (user != null) {
            userService.changePassword(user, newPassword);
        }
    }

    @PostMapping("/subscribe")
    public void subscribe(@RequestParam Long followerId, @RequestParam Long followeeId) {
        User follower = userService.getAllUsers().stream().filter(u -> u.getId().equals(followerId)).findFirst().orElse(null);
        User followee = userService.getAllUsers().stream().filter(u -> u.getId().equals(followeeId)).findFirst().orElse(null);
        if (follower != null && followee != null) {
            userService.subscribeToUser(follower, followee);
        }
    }

    @GetMapping("/subscriptions/{userId}")
    public List<User> getSubscriptions(@PathVariable Long userId) {
        User user = userService.getAllUsers().stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        if (user != null) {
            return userService.getSubscriptions(user);
        }
        return null;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User user = userService.getAllUsers().stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        if (user != null) {
            userService.deleteUser(user);
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}/role")
    public void updateUserRole(@PathVariable Long userId, @RequestParam Role role) {
        userService.updateUserRole(userId, role);
    }
}
