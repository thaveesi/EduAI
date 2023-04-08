package com.example.EduAI.controller;

import com.example.EduAI.dto.CoursePlanDto;
import com.example.EduAI.service.CoursePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-plans")
public class CoursePlanController {

    @Autowired
    private CoursePlanService coursePlanService;

    @PostMapping
    public ResponseEntity<CoursePlanDto> createCoursePlan(@RequestBody CoursePlanDto coursePlanDto) {
        // Add logic for creating a course plan
        CoursePlanDto createdCoursePlan = coursePlanService.createCoursePlan(coursePlanDto);
        return ResponseEntity.ok(createdCoursePlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoursePlanDto> updateCoursePlan(@PathVariable Long id, @RequestBody CoursePlanDto coursePlanDto) {
        // Add logic for updating a course plan
        CoursePlanDto updatedCoursePlan = coursePlanService.updateCoursePlan(id, coursePlanDto);
        return ResponseEntity.ok(updatedCoursePlan);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoursePlan(@PathVariable Long id) {
        // Add logic for deleting a course plan
        coursePlanService.deleteCoursePlan(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursePlanDto> getCoursePlan(@PathVariable Long id) {
        // Add logic for retrieving a course plan
        CoursePlanDto coursePlanDto = coursePlanService.getCoursePlan(id);
        return ResponseEntity.ok(coursePlanDto);
    }

    @GetMapping
    public ResponseEntity<List<CoursePlanDto>> getAllCoursePlans() {
        // Add logic for retrieving all course plans
        List<CoursePlanDto> coursePlans = coursePlanService.getAllCoursePlans();
        return ResponseEntity.ok(coursePlans);
    }
}
