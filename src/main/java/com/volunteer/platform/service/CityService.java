package com.volunteer.platform.service;

import com.volunteer.platform.model.City;
import com.volunteer.platform.model.Project;

import java.util.List;

public interface CityService {
    List<Project> getProjectsForCity(City city);
    List<City> getAllCities();
    void deleteCity(City city);
    void addCity(City city);
}
