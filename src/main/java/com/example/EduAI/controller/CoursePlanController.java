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

//    @Autowired
//    private CoursePlanService coursePlanService;
//
//    @PostMapping
//    public ResponseEntity<CoursePlanDto> createCoursePlan(@RequestBody CoursePlanDto coursePlanDto) {
//        // Add logic for creating a course plan
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CoursePlanDto> updateCoursePlan(@PathVariable Long id, @RequestBody CoursePlanDto coursePlanDto) {
//        // Add logic for updating a course plan
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCoursePlan(@PathVariable Long id) {
//        // Add logic for deleting a course plan
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CoursePlanDto> getCoursePlan(@PathVariable Long id) {
//        // Add logic for retrieving a course plan
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CoursePlanDto>> getAllCoursePlans() {
//        // Add logic for retrieving all course plans
//    }
}
