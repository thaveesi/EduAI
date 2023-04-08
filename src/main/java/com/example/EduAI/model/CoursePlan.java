package com.example.EduAI.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "course_plans")
public class CoursePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_plan_id")
    private List<Resource> resources;

    // Add getters, setters, and constructors.
}
