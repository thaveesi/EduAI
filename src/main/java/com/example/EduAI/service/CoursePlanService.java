package com.example.EduAI.service;

import com.example.EduAI.dto.CoursePlanDto;
import com.example.EduAI.model.CoursePlan;
import com.example.EduAI.repository.CoursePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursePlanService {

    @Autowired
    private CoursePlanRepository coursePlanRepository;

    public CoursePlanDto createCoursePlan(CoursePlanDto coursePlanDto) {
        // Add logic for creating a course plan
        CoursePlan coursePlan = new CoursePlan();
        coursePlan.setName(coursePlanDto.getName());
        coursePlan.setStartDate(coursePlanDto.getStartDate());
        coursePlan.setEndDate(coursePlanDto.getEndDate());
        coursePlan.setResources(coursePlanDto.getResources());

        CoursePlan savedCoursePlan = coursePlanRepository.save(coursePlan);
        return new CoursePlanDto(savedCoursePlan);
    }

    public CoursePlanDto updateCoursePlan(Long id, CoursePlanDto coursePlanDto) {
        // Add logic for updating a course plan
        CoursePlan coursePlan = coursePlanRepository.findById(id).orElseThrow();
        coursePlan.setName(coursePlanDto.getName());
        coursePlan.setStartDate(coursePlanDto.getStartDate());
        coursePlan.setEndDate(coursePlanDto.getEndDate());
        coursePlan.setResources(coursePlanDto.getResources());

        CoursePlan updatedCoursePlan = coursePlanRepository.save(coursePlan);
        return new CoursePlanDto(updatedCoursePlan);
    }

    public void deleteCoursePlan(Long id) {
        // Add logic for deleting a course plan
        coursePlanRepository.deleteById(id);
    }

    public CoursePlanDto getCoursePlan(Long id) {
        // Add logic for retrieving a course plan
        CoursePlan coursePlan = coursePlanRepository.findById(id).orElseThrow();
        return new CoursePlanDto(coursePlan);
    }

    public List<CoursePlanDto> getAllCoursePlans() {
        // Add logic for retrieving all course plans
        List<CoursePlan> coursePlans = coursePlanRepository.findAll();
        return coursePlans.stream()
                .map(CoursePlanDto::new)
                .collect(Collectors.toList());
    }

    // Add any additional methods or configurations required for CoursePlanService
}

