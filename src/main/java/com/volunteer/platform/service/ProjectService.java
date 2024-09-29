package com.volunteer.platform.service;

import com.volunteer.platform.model.Project;
import com.volunteer.platform.model.Volunteer;
import java.util.List;

public interface ProjectService {
    void createProject(Project project);
    void updateProject(Project project);
    void deleteProject(Project project);
    List<Volunteer> getVolunteers(Project project);  // Обратите внимание на тип возвращаемого значения
    void notifyVolunteers(Project project, String message);
    List<Project> getAllProjects();
}
