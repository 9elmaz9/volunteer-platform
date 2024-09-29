package com.volunteer.platform.controller;

import com.volunteer.platform.model.Project;
import com.volunteer.platform.model.Volunteer;
import com.volunteer.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{projectId}/volunteers")
    public List<Volunteer> getVolunteers(@PathVariable Long projectId) {
        Project project = projectService.getAllProjects().stream().filter(p -> p.getId().equals(projectId)).findFirst().orElse(null);
        if (project != null) {
            return projectService.getVolunteers(project);
        }
        return null;
    }

    @PostMapping("/{projectId}/notify")
    public void notifyVolunteers(@PathVariable Long projectId, @RequestParam String message) {
        Project project = projectService.getAllProjects().stream().filter(p -> p.getId().equals(projectId)).findFirst().orElse(null);
        if (project != null) {
            projectService.notifyVolunteers(project, message);
        }
    }

    @PostMapping
    public void createProject(@RequestBody Project project) {
        projectService.createProject(project);
    }

    @PutMapping("/{projectId}")
    public void updateProject(@PathVariable Long projectId, @RequestBody Project project) {
        project.setId(projectId);
        projectService.updateProject(project);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        Project project = new Project();
        project.setId(projectId);
        projectService.deleteProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
}
