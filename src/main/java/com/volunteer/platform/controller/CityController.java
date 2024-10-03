package com.volunteer.platform.controller;

import com.volunteer.platform.model.City;
import com.volunteer.platform.model.Project;
import com.volunteer.platform.service.impl.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private FeedbackServiceImpl.CityService cityService;

    @PostMapping
    public void addCity(@RequestBody City city) {
        cityService.addCity(city);
    }

    @DeleteMapping("/{cityId}")
    public void deleteCity(@PathVariable Long cityId) {
        City city = new City();
        city.setId(cityId);
        cityService.deleteCity(city);
    }

    @GetMapping("/{cityId}/projects")
    public List<Project> getProjectsForCity(@PathVariable Long cityId) {
        City city = new City();
        city.setId(cityId);
        return cityService.getProjectsForCity(city);
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }
}
