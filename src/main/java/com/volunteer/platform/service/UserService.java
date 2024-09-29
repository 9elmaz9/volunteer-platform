package com.volunteer.platform.service;

import com.volunteer.platform.model.User;
import com.volunteer.platform.model.Role;

import java.util.List;

public interface UserService {
    void register(User user);
    User login(String email, String password);
    void updateProfile(User user);
    void changePassword(User user, String newPassword);
    void subscribeToUser(User follower, User followee);
    List<User> getSubscriptions(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
    void updateUserRole(Long userId, Role role);
}
