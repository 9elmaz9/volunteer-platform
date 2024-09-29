package com.volunteer.platform.controller;

import com.volunteer.platform.model.User;
import com.volunteer.platform.model.Project;
import com.volunteer.platform.model.Role;
import com.volunteer.platform.service.UserService;
import com.volunteer.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/users/{userId}/role")
    public void updateUserRole(@PathVariable Long userId, @RequestParam Role role) {
        userService.updateUserRole(userId, role);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User user = userService.getAllUsers().stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        if (user != null) {
            userService.deleteUser(user);
        }
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
}
