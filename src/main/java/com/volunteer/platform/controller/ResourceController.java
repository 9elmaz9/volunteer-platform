package com.volunteer.platform.controller;

import com.volunteer.platform.model.Resource;
import com.volunteer.platform.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public void addResource(@RequestBody Resource resource) {
        resourceService.addResource(resource);
    }

    @DeleteMapping("/{resourceId}")
    public void deleteResource(@PathVariable Long resourceId) {
        Resource resource = new Resource();
        resource.setId(resourceId);
        resourceService.deleteResource(resource);
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }
}
