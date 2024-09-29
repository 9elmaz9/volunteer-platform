package com.volunteer.platform.service;

import com.volunteer.platform.model.Resource;
import com.volunteer.platform.repository.ResourceRepository;
import com.volunteer.platform.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public void addResource(Resource resource) {
        resourceRepository.save(resource);
    }

    @Override
    public void deleteResource(Resource resource) {
        resourceRepository.delete(resource);
    }
}
