package com.example.EduAI.dto;

import com.example.EduAI.model.CoursePlan;
import com.example.EduAI.model.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursePlanDto {

    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<Resource> resources;

    // Add getters, setters, and constructors.
    public CoursePlanDto(CoursePlan coursePlan) {
        this.id = coursePlan.getId();
        this.name = coursePlan.getName();
        this.description = coursePlan.getDescription();
        this.startDate = coursePlan.getStartDate();
        this.endDate = coursePlan.getEndDate();
        this.resources = coursePlan.getResources();
    }
}
