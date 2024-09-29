package com.volunteer.platform.service;

import com.volunteer.platform.model.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> getAllResources();
    void addResource(Resource resource);
    void deleteResource(Resource resource);
}
