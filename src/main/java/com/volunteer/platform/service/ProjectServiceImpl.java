package com.volunteer.platform.service;

import com.volunteer.platform.model.Project;
import com.volunteer.platform.model.Volunteer;
import com.volunteer.platform.repository.ProjectRepository;
import com.volunteer.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public List<Volunteer> getVolunteers(Project project) {
        return project.getVolunteers();
    }

    @Override
    public void notifyVolunteers(Project project, String message) {
        // Implementation for notifying volunteers
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
