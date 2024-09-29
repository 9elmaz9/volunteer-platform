package com.volunteer.platform.service;

import com.volunteer.platform.model.City;
import com.volunteer.platform.model.Project;
import com.volunteer.platform.repository.CityRepository;
import com.volunteer.platform.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<Project> getProjectsForCity(City city) {
        return city.getProjects();
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public void deleteCity(City city) {
        cityRepository.delete(city);
    }

    @Override
    public void addCity(City city) {
        cityRepository.save(city);
    }
}
